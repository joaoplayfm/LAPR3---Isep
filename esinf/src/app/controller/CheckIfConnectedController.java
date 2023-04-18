package app.controller;

import app.Model.Local;
import app.graph.Algorithms;
import app.graph.matrix.MatrixGraph;

import static app.graph.Algorithms.MinConnections;

public class CheckIfConnectedController {



    public boolean checkConnectivity(MatrixGraph<Local,Double> g) {

        System.out.println(MinConnections(g));
        return  Algorithms.isConnected(g) ;


    }




}




