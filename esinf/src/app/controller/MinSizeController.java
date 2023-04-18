package app.controller;

import app.Model.Cabaz;
import app.Model.Empresa;
import app.Model.Local;
import app.graph.Algorithms;
import app.graph.matrix.MatrixGraph;

import java.util.*;

public class MinSizeController {

    MinDistController minDistController;
    public MinSizeController() {
    minDistController = new MinDistController();


    }

    /**
     * This function return the Cabax List of the day that you want
     * @param day the day of the Cabaz List
     * @param res cabaz list
     * @return the cabaz list of the day that you want
     */
    public List<Cabaz> CabazesByDay(int day, List<Cabaz> res) {
        List<Cabaz> cabazList = new ArrayList<>();
        for (Cabaz c1 : res) {

            if (c1.getDay() == day) {
                cabazList.add(c1);

            }

        }
        return cabazList;

    }

    /**
     * Functio to return all the days of the list
     * @param c cabaz list
     * @return all the days of the list
     */
    public Set<Integer> getDays(List<Cabaz>c){

        Set<Integer> days = new HashSet<Integer>();
        for(Cabaz cabaz : c){
            days.add(cabaz.day);
        }

        return days;
    }

    /**
     * Remove the clients (C)
     * @param cabazs cabaz list
     * @return the list without clients(C)
     */
    public List<Cabaz> removeClients(List<Cabaz> cabazs)
    {    List<Cabaz> cabazPE = new ArrayList<>(cabazs);
        for (Cabaz l1 : cabazs)
        {
            if (l1.id.contains("C"))
            {
                cabazPE.remove(l1);
            }
        }

        return cabazPE;
    }

    /**
     * The list with only Productores and Hubs (P and E)
     * @param graphList graph
     * @param cabazList cabaz list
     * @return The graph with only Productores and Hubs (P and E)
     */
    public MatrixGraph<Local, Double> getDayGraph(MatrixGraph<Local, Double> graphList, List<Cabaz>cabazList){

        MatrixGraph<Local,Double> graph=new MatrixGraph<>(false, cabazList.size());

        for(Local v : graphList.vertices())
        {
            for(Cabaz c : cabazList)
            {
                if (v.getType().contains(c.id))
                {
                    graph.addVertex(v);
                    break;
                }
            }
        }
        return graph;
    }

    /**
     * Indicates the crossing points of the route (producers and hubs)
     * @param cabazes cabaz list
     * @param matrixGraph graph
     * @return a list with the crossing points of the route (producers and hubs)
     */
    public List<Local> getShortest(List<Cabaz> cabazes, MatrixGraph<Local, Double> matrixGraph)
    {
        List<Local> rtnList = new ArrayList<>();

        MatrixGraph<Local,Double> graph=new MatrixGraph<>(false, cabazes.size());

        graph=getDayGraph(matrixGraph, cabazes);

        return Algorithms.minDistGraph(graph, Double::compare, Double::sum).vertices();
    }

    /**
     * distance between all waypoints and the total distance
     * @param graph graph
     * @param cabazes cabaz list
     * @return distance between all waypoints and the total distance.
     */
    public List<Empresa> getDistance(MatrixGraph<Local, Double> graph, List<Cabaz>cabazes) {

        List<Empresa> companyHubs = new ArrayList<>();
        LinkedList<Local> localList = new LinkedList<>();
        ArrayList<LinkedList<Local>> hubsList = new ArrayList<>();

        Double total_sum = 0.0;
        for (Local l1 : graph.vertices())
        {
            if (l1.getType().contains("E") || l1.getType().contains("P"))
            {
                for (Local l2 : graph.vertices())
                {
                    if (!l2.getType().contains("C"))
                    {
                        total_sum += Algorithms.shortestPath(graph, l1, l2, Double::compare, Double::sum, 0.0, localList);
                        hubsList.add(localList);
                    }
                }
                Empresa futureHub = new Empresa(l1.getId(), l1.getLati(), l1.getLongi(), total_sum, l1.getType());
                companyHubs.add(futureHub);
            }
        }
        System.out.println("Soma Total: ");
        System.out.println(total_sum);
        System.out.println("Soma entre pontos: ");
        return companyHubs;
    }
}
