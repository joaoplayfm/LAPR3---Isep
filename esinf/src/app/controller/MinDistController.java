package app.controller;


import app.Model.Local;
import app.graph.Algorithms;
import app.graph.matrix.MatrixGraph;
import java.util.List;

public class MinDistController {


    public MinDistController() {


    }

    /**
     *
     * @param matrixGraph we receive the matrix that are filled-in with all values
     * @return a list that presents the smallest distance for customers and producers (C1 to P3)
     */
    public List<Local> getShortestPath(MatrixGraph<Local, Double> matrixGraph)
    {
        MatrixGraph<Local, Double> graph = new MatrixGraph<>(matrixGraph);
        for (Local l1 : graph.vertices())
        {
            if (l1.getType().contains("E"))
            {
                graph.removeVertex(l1);
            }
        }
       return Algorithms.minDistGraph(graph, Double::compare, Double::sum).vertices();
    }
}
