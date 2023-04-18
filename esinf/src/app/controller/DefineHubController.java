package app.controller;

import app.Model.Empresa;
import app.Model.Hub;
import app.Model.Local;
import app.graph.Algorithms;
import app.graph.matrix.MatrixGraph;

import java.io.IOException;
import java.util.*;

public class  DefineHubController {

    List<Empresa> companyHubs = new ArrayList<>();
    List<Hub> companyHubsSorted = new ArrayList<>();
    List<Hub> listHubsClient = new ArrayList<>();
    List<Local> localList = new ArrayList<>();
    Map<Local, Hub> getNearestHub = new HashMap<>();


    ///// US 303
    public List<Empresa> getClosestHubs(MatrixGraph<Local, Double> matrixGraph) {


        LinkedList<Local> localList = new LinkedList<>();
        ArrayList<LinkedList<Local>> hubsList = new ArrayList<>();

        Double sum = 0.0;
        int i = 0;
        Double average = 0.0;
        Double total_sum = 0.0;
        double zero = 0.0;
        for (Local l1 : matrixGraph.vertices()) {
            if (l1.getType().contains("C") || l1.getType().contains("P")) {
            } else {
                for (Local l2 : matrixGraph.vertices()) {
                    if (l2.getType().contains("E")) {

                    } else {

                        sum = Algorithms.shortestPath(matrixGraph, l1, l2, Double::compare, Double::sum, zero, localList);
                        i++;
                        total_sum = total_sum + sum;
                        hubsList.add(localList);

                    }

                }
                average = total_sum / i;
                Empresa futureHub = new Empresa(l1.getId(), l1.getLati(), l1.getLongi(), average, l1.getType());
                companyHubs.add(futureHub);
                i = 0;
            }


        }

        //System.out.println(paths);
        return companyHubs;

    }


    public List<Hub> mostCentralHubs(Integer n, List<Empresa> companyHubs) {

        Collections.sort(companyHubs, new Comparator<Empresa>() {

            @Override
            public int compare(Empresa o1, Empresa o2) {
                return (o1.getCentralDistance().compareTo(o2.getCentralDistance()));
            }


        });
        for (int i = 0; i < n; i++) {
            Hub hubSorted = new Hub(companyHubs.get(i).getId(), companyHubs.get(i).getLati(), companyHubs.get(i).getLongi(), companyHubs.get(i).getCentralDistance(), companyHubs.get(i).getType());
            companyHubsSorted.add(hubSorted);
        }


        return companyHubsSorted;

    }


    ////// US 304
    public Local getClientById(String id) throws IOException {
        for (Local p : localList) {
            if (p.id.equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Map<Local, Hub> getNearestHub(MatrixGraph<Local, Double> matrixGraph, List<Hub> companyHubsSorted) throws IOException {

        LinkedList<Local> localList = new LinkedList<>();
        Double sum = 0.0;
        double zero = 0;


        for (Local l1 : matrixGraph.vertices()) {
            if (l1.getType().contains("C") || l1.getType().contains("P")) {
                for (Local l2 : matrixGraph.vertices()) {
                    for (Hub h1 : companyHubsSorted) {
                        if (l2.getType().equals(h1.getType())) {
                            sum = Algorithms.shortestPath(matrixGraph, l1, l2, Double::compare, Double::sum, zero, localList);
                            Hub closestIndex = new Hub(l2.getId(), l2.getLati(), l2.getLongi(), sum, l2.getType());
                            listHubsClient.add(closestIndex);


                        }


                    }
                    Collections.sort(listHubsClient, new Comparator<Hub>() {

                        @Override
                        public int compare(Hub o1, Hub o2) {
                            return (o1.getCentralDistance().compareTo(o2.getCentralDistance()));
                        }


                    });
                }
                Local client = new Local(l1.getId(), l1.getLati(), l1.getLongi(), l1.getType());
                getNearestHub.put(client, listHubsClient.get(0));

            }

        }

        return getNearestHub;

    }



}
