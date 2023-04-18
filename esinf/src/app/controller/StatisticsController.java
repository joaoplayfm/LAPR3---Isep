package app.controller;

import app.Model.Cabaz;

import java.util.*;

/**
 * The Statistics controller.
 */
public class StatisticsController {
    ExpeditionListController expeditionListController = new ExpeditionListController();

    /**
     * Statistics per cabaz. US311
     *
     * @param cabazList the cabaz list
     */
    public void statisticsPerCabaz(List<Cabaz> cabazList) {
        Map<String, List<Double>> results = new HashMap<>();
        int produtosSatisfeitos = 0, produtosParcSatisfeitos = 0, produtosNaoSatisfeitos = 0, i = 0, produtosNoCabaz = 0;
        System.out.println("Por Cabaz:\n");
        for (int day = 1; day < 6; day++) {
            Set<String> prodInvolved = new HashSet<>();
            List<Cabaz> clientList = expeditionListController.CabazOnTheDay(day, cabazList);
            List<Cabaz> prodList = expeditionListController.ProdByDayAndP(day, cabazList);
            Map<String, Map<String, Double>> expeditionList = expeditionListController.expeditionList(prodList, clientList);

            for (Cabaz c : clientList) {
                System.out.printf("ID: %s, Day: %d\n", c.id, c.day);

                Iterator<Map.Entry<String, Map<String, Double>>> it = expeditionList.entrySet().iterator();
                //Map.Entry<String, Map<String, Double>> entry = it.next();
                //System.out.println("\n" + entry.getKey() + ": " + c.getId());

                for (Map.Entry<String, Map<String, Double>> entry : expeditionList.entrySet()) {
                    if (entry.getKey().contains(c.getId())) {
                        //System.out.println(entry.getKey() + "               :           " + c + "\n");

                        for (int j = 12; j > 0; j--) {
                            Iterator<Map.Entry<String, Map<String, Double>>> itR = expeditionList.entrySet().iterator();
                            String s3 = "Produto:", s4 = Integer.toString(j), s1 = "Cliente:", s2 = c.id;
                            String s = s1 + s2 + "  " + s3 + s4;
                            //System.out.println(s + "        eeeee        " + c.getProdGeneric(j));

                            if (c.getProdGeneric(j) != 0) {
                                Iterator<Map.Entry<String, Map<String, Double>>> itEntry = expeditionList.entrySet().iterator();
                                while (!(entry.getKey().equals(s)) && it.hasNext()) {
                                    //System.out.println("hiii");
                                    //System.out.println(entry.getKey());
                                    entry = it.next();
                                }

                                if (entry.getKey().equals(s)) {
                                    //System.out.println("u made it");
                                    Iterator<Map.Entry<String, Double>> it2 = entry.getValue().entrySet().iterator();
                                    Iterator<Map.Entry<String, Double>> it88 = itEntry.next().getValue().entrySet().iterator();
                                    Map.Entry<String, Double> entry2 = it2.next();
                                    Map.Entry<String, Double> biggestEntry2 = entry2;

                                    for (Map.Entry<String, Double> uiii : entry.getValue().entrySet()) {
                                        if (biggestEntry2.getValue() < uiii.getValue()) {
                                            biggestEntry2 = uiii;
                                        }
                                    }

                                    if (biggestEntry2.getValue() >= c.getProdGeneric(j)) {
                                        //System.out.println("\n" + entry2);
                                        produtosSatisfeitos++;
                                        produtosNoCabaz++;
                                        prodInvolved.add(entry2.getKey());

                                    } else {
                                        if (biggestEntry2.getValue() < c.getProdGeneric(j) && biggestEntry2.getValue() > 0) {
                                            //System.out.println("\n" + entry2);
                                            produtosParcSatisfeitos++;

                                            prodInvolved.add(entry2.getKey());
                                        }

                                        if (biggestEntry2.getValue() == 0) {
                                            produtosNaoSatisfeitos++;
                                            produtosNoCabaz++;
                                        }
                                    }
                                }
                            }
                        }

                    }

                }
                System.out.printf("Número de produtos satisfeitos: %d\n", produtosSatisfeitos / 2);
                System.out.printf("Número de produtos parcialmente satisfeitos: %d\n", produtosParcSatisfeitos / 2);
                System.out.printf("Número de produtos não satisfeitos: %d\n", produtosNaoSatisfeitos / 2);
                if (produtosNoCabaz == 0)
                    produtosNoCabaz = 1;
                double percentSatisfeitos = (((produtosSatisfeitos) + (produtosParcSatisfeitos) / 2) / produtosNoCabaz) * 50;
                System.out.printf("Percentagem de Cabaz Satisfeito: %.2f\n", percentSatisfeitos);
                System.out.printf("Número de produtores envolvidos no cabaz: %d\n", prodInvolved.size());
                System.out.println("------------------------------------------------");


                List<Double> resultProd = new ArrayList<>();
                resultProd.add((double) produtosSatisfeitos);
                resultProd.add((double) produtosParcSatisfeitos);
                resultProd.add((double) produtosNaoSatisfeitos);
                resultProd.add(percentSatisfeitos);
                resultProd.add((double) prodInvolved.size());
                results.put(c.id, resultProd);
                produtosSatisfeitos = 0;
                produtosParcSatisfeitos = 0;
                produtosNaoSatisfeitos = 0;
                produtosNoCabaz = 0;
            }
        }
        System.out.println();
        System.out.println();
        Set<String> clientes = new HashSet<String>();
        for (int day = 1; day < 6; day++) {
            List<Cabaz> clientList = expeditionListController.CabazOnTheDay(day, cabazList);
            for (Cabaz c : clientList) {
                clientes.add(c.id);
            }
        }

        for (String cliente : clientes) {
            System.out.println(cliente);
            int cabazesParcSatisfeitos = 0, cabazesSatisfeitos = 0, cabazesNaoSatisfeitos = 0;
            Iterator<Map.Entry<String, List<Double>>> iterator = results.entrySet().iterator();
            double prodInvolved = 0;
            while (iterator.hasNext()) {
                Map.Entry<String, List<Double>> entryyy = iterator.next();
                if (cliente.equals(entryyy.getKey())) {
                    if (entryyy.getValue().get(3) == null || entryyy.getValue().get(3) == 0) {
                        cabazesNaoSatisfeitos++;
                    }
                    if (entryyy.getValue().get(3) == 100) {
                        cabazesSatisfeitos++;
                        prodInvolved += entryyy.getValue().get(4);

                    } else {
                        cabazesParcSatisfeitos++;
                        prodInvolved += entryyy.getValue().get(4);

                    }
                    iterator.remove();
                }

            }
            System.out.println("Número de cabazes Satisfeitos: " + cabazesSatisfeitos);
            System.out.println("Número de cabazes Parcialmente Satisfeitos: " + cabazesParcSatisfeitos);
            System.out.println("Número de cabazes Não Satisfeitos: " + cabazesNaoSatisfeitos);
            System.out.println("Número de produtores que forneceram os cabazes: " + prodInvolved);
            System.out.println();
        }
    }
}


