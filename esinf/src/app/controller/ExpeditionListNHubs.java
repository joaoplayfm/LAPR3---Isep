package app.controller;

import app.Model.Cabaz;
import app.Model.Empresa;
import app.Model.Hub;
import app.Model.Local;
import app.graph.Algorithms;
import app.graph.matrix.MatrixGraph;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.*;

public class ExpeditionListNHubs {
    List<String> Prods = new ArrayList<>();
    DefineHubController defineHubController = new DefineHubController();
    ExpeditionListController controller = new ExpeditionListController();


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


    public Map<String,Double> expeditionListProximity(List<Cabaz> prodList, List<Cabaz> clientList, MatrixGraph<Local, Double> matrixGraph) throws IOException {
        Map<String, Map<String, Double>> fullMap = controller.expeditionList(prodList,clientList);
        Map<String, Map<String, Double>> fullMapToSort = new HashMap<>();
        Map<String,Double> testMap = new HashMap<>();

        List<Empresa> empresaList1 = defineHubController.getClosestHubs(matrixGraph);
        List<Hub> hubList = defineHubController.mostCentralHubs(5, empresaList1);
        Map<Local, Hub> mapa = defineHubController.getNearestHub(matrixGraph, hubList);
        Map<String,Double> prodAndDistance = new HashMap<>();


        for(Map.Entry<Local, Hub> en: mapa.entrySet()) {
            if (en.getKey().getType().contains("C") || en.getKey().getType().contains("P") ) {
                prodAndDistance.put(en.getKey().getType(), en.getValue().getCentralDistance());

            }
        }

        for(Map.Entry<String, Map<String, Double>> eg: fullMap.entrySet()){
            for(Map.Entry<String,Double> ef: eg.getValue().entrySet()){
                for(Map.Entry<String,Double> ep : prodAndDistance.entrySet()){
                    if(ef.getKey().equals(ep.getKey()) || eg.getKey().contains(ep.getKey())){

                        Map<String, Double> partialMapToSort = new HashMap<>();



                        partialMapToSort.put(ef.getKey(),ep.getValue());

                        fullMapToSort.put(eg.getKey(),partialMapToSort);
                        testMap.put(eg.getKey() + " " + ef.getKey() +" --->" + "Distance",ep.getValue());


                    }

                }

            }

        }






        List<Map.Entry<String,Double>> entryList = new ArrayList<>(testMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        return testMap;
    }
}

