package app.controller;

import app.Model.Cabaz;

import java.util.*;

public class ExpeditionListController {


    public List<Cabaz> CabazOnTheDay(int day, List<Cabaz> list) {

        List<Cabaz> res = new ArrayList<>();
        for (Cabaz c1 : list) {
            if (c1.getDay() == day && c1.getId().contains("C")) {
                res.add(c1);
            }

        }


        return res;


    }

    public List<Cabaz> ProdByDayAndP(int day, List<Cabaz> res) {
        List<Cabaz> prodList = new ArrayList<>();
        for (Cabaz c1 : res) {

            if (c1.getDay() == day && c1.getId().contains("P")) {
                prodList.add(c1);

            }

        }
        return prodList;

    }

    public Map<String, Map<String, Double>> expeditionList(List<Cabaz> prodList, List<Cabaz> clientList) {

        Map<String, Map<String, Double>> fullMap = new HashMap<>();
        int i = 1;
        int count = 0;
        for (Cabaz p1 : clientList) {
            if (p1.getProd13() != null) {
                count = 1;
            } }

//            // --------------------------------SMALL -----------------------------
        if (count == 0) {


            do {

                for (Cabaz c1 : clientList) {
                    Map<String, Double> partialMap = new HashMap<>();
                    Double aux = c1.getProdGeneric(i);


                    for (Cabaz c2 : prodList) {

                        if (c1.getProdGeneric(i) == 0) {
                            partialMap.put(c2.getId(), 0.0);
                            fullMap.put("Cliente:" + c1.getId() + "  " + "Produto:" + i, partialMap);

                        } else {
                            Double aux2 = c2.getProdGeneric(i);
                            Double aux3 = aux;
                            aux = aux - aux2;
                            if (aux < 0) {
                                if (aux3 < 0) {
                                    partialMap.put(c2.getId(), 0.0);
                                    fullMap.put("Cliente:" + c1.getId() + "  " + "Produto:" + i, partialMap);

                                } else {
                                    partialMap.put(c2.getId(), aux3);
                                    fullMap.put("Cliente:" + c1.getId() + "  " + "Produto:" + i, partialMap);

                                }


                            } else {
                                partialMap.put(c2.getId(), c2.getProdGeneric(i));
                                fullMap.put("Cliente:" + c1.getId() + "  " + "Produto:" + i, partialMap);

                            }

                        }

                    }

                }

                i++;


            } while (i < 13);

            // --------------------BIG --------------------
        } else {
            do {
                for (Cabaz c1 : clientList) {
                    Map<String, Double> partialMap = new HashMap<>();
                    Double aux = c1.getProdGeneric(i);


                    for (Cabaz c2 : prodList) {

                        if (c1.getProdGeneric(i) == 0) {
                            partialMap.put(c2.getId(), 0.0);
                            fullMap.put("Cliente:" + c1.getId() + "  " + "Produto:" + i, partialMap);

                        } else {
                            Double aux2 = c2.getProdGeneric(i);
                            Double aux3 = aux;
                            aux = aux - aux2;
                            if (aux < 0) {
                                if (aux3 < 0) {
                                    partialMap.put(c2.getId(), 0.0);
                                    fullMap.put("Cliente:" + c1.getId() + "  " + "Produto:" + i, partialMap);

                                } else {
                                    partialMap.put(c2.getId(), aux3);
                                    fullMap.put("Cliente:" + c1.getId() + "  " + "Produto:" + i, partialMap);

                                }


                            } else {
                                partialMap.put(c2.getId(), c2.getProdGeneric(i));
                                fullMap.put("Cliente:" + c1.getId() + "  " + "Produto:" + i, partialMap);

                            }

                        }

                    }

                }

                i++;


            } while (i < 21);
        }


        return fullMap;
    }



}
