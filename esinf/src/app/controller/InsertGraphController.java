package app.controller;


import app.Model.Empresa;
import app.Model.Hub;
import app.Model.Length;
import app.Model.Local;
import app.graph.Algorithms;
import app.graph.matrix.MatrixGraph;

import java.io.IOException;
import java.util.*;
import java.util.function.BinaryOperator;

public class InsertGraphController {

    List<Hub> companyHubsSorted = new ArrayList<>();
    List<Hub> listHubsClient = new ArrayList<>();
    List<Local> localList = new ArrayList<>();
    Map<Local, Hub> getNearestHub = new HashMap<>();
    MatrixGraph<Local, Double> graph = new MatrixGraph<>(false, 400);
    List<Empresa> companyHubs = new ArrayList<>();

    public InsertGraphController() {

    }

    public String addVertex(List<Local> list) {
        int numV = 0;
        for (Local l : list) {
            graph.addVertex(l);
            numV++;
        }
        return numV + "added";
    }

    public String addEdges(List<Length> list) {
        int numE = 0;
        for (Length l : list) {
            double dist = l.getLength();
            int key1 = checkKey(l.id1);
            int key2 = checkKey(l.id2);

            Local local = graph.vertex(key1);
            Local local1 = graph.vertex(key2);
            graph.addEdge(local, local1, dist);
            numE++;
        }
        return numE + "added";
    }

    public int checkKey(String id) {
        int k = 0;
        boolean check = false;
        while (check == false) {
            Local local = graph.vertex(k);
            if (local.id.equals(id)) {
                check = true;
            } else k++;
        }
        return k;
    }

    public MatrixGraph<Local, Double> returnGraph() {
        graph.resizeMatrix();
        return graph;
    }


    Comparator<Double> compdouble = new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return (int) (o1 - o2);
        }
    };
    BinaryOperator<Double> sum = new BinaryOperator<Double>() {
        @Override
        public Double apply(Double aDouble, Double aDouble2) {
            return aDouble + aDouble2;
        }
    };


}