package app.ui;


import app.Model.*;
import app.controller.*;
import app.graph.Algorithms;
import app.graph.FileReaderCabazes;
import app.graph.FileReaderGraphs;
import app.graph.matrix.MatrixGraph;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MenuUI implements Runnable {
    FileReaderGraphs graphs;
    InsertGraphController controller;
    MinDistController minDistController;
    MinSizeController minSizeController;
    DefineHubController defineHubController;
    SistemaRegaController sistemaRegaController = new SistemaRegaController();
    StatisticsController statisticsController = new StatisticsController();
    CheckIfConnectedController checkIfConnectedController;
    FileReaderCabazes cabazes;
    List<Local> list = new ArrayList<>();
    MatrixGraph<Local,Double> graph=new MatrixGraph<>(false,list.size());
    List<Cabaz> cabazList= new ArrayList<>();
    ExpeditionListController expeditionListController;
    ExpeditionListNHubs expeditionListNHubs;


    int option;
    int numberOfHubs;

    public MenuUI() {
        controller = new InsertGraphController();
        graphs = new FileReaderGraphs();
        minDistController = new MinDistController();
        defineHubController = new DefineHubController();
        checkIfConnectedController = new CheckIfConnectedController();
        cabazes=new FileReaderCabazes();
        expeditionListController = new ExpeditionListController();
        expeditionListNHubs = new ExpeditionListNHubs();
        minSizeController = new MinSizeController();
        statisticsController = new StatisticsController();
    }

    public void run() {
        boolean success = false;
        try {
            success = Menu();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        if (success) System.out.println("\nThe operation was successful.");

    }


    public boolean Menu() throws IOException, ParseException {

        do {
            System.out.println("\n1-Create graph");
            System.out.println("2-Verify if the graph is connected");
            System.out.println("3-Define hubs");
            System.out.println("4-Search for client nearest hub");

            System.out.println("5-Minimal distance between clients and productores");
            System.out.println("6-Watering System");

            System.out.println("7-Import basket list");
            System.out.println("8-Generate basket expedition list without restrictions");
            System.out.println("9-Generate basket expedition list with restrictions");
            System.out.println("10-Delivery route that minimizes the total distance traveled");
            System.out.println("11-Calculate Statistic of expedition list");

            System.out.println(" -1  to Exit!");
            option = Utils.readIntegerFromConsole("Please select the desired option: ");
            switch (option) {
                case 1:
                    int bigorsmall = Utils.readIntegerFromConsole("1- SMALL           2-BIG");
                    if (bigorsmall == 1) {

                        list = graphs.readVertices("clientes-produtores_small.csv");
                        graph = new MatrixGraph<>(false, list.size());
                        System.out.println(list);
                        List<Length> lengthList = graphs.readEdges("distancias_small.csv");
                        System.out.println(lengthList);
                        System.out.println(controller.addVertex(list));
                        System.out.println(controller.addEdges(lengthList));
                        System.out.println(controller.returnGraph().toString());
                    }

                    if (bigorsmall == 2) {
                        list = graphs.readVertices("clientes-produtores_big.csv");
                        graph = new MatrixGraph<>(false, list.size());
                        System.out.println(list);
                        List<Length> lengthList = graphs.readEdges("distancias_big.csv");
                        System.out.println(lengthList);
                        System.out.println(controller.addVertex(list));
                        System.out.println(controller.addEdges(lengthList));
                        System.out.println(controller.returnGraph().toString());
                    }
                    break;


                case 2:
                    graph = controller.returnGraph();
                    System.out.println("\nO grafo Ã© conexo:" + checkIfConnectedController.checkConnectivity(graph) + "\n");
                    boolean isConnected = checkIfConnectedController.checkConnectivity(graph);
                    if (isConnected) {
                        int minConnections = Algorithms.MinConnections(graph);
                        System.out.println("The minimum number of connections needed in the graph is: " + minConnections);
                    } else {
                        System.out.println("The graph is not connected.");
                    }

                    break;


                case 3:
                    graph = controller.returnGraph();
                    List<Empresa> empresaList = defineHubController.getClosestHubs(graph);
                    numberOfHubs = Utils.readIntegerFromConsole("How many hubs do you wish to create?");
                    List<Hub> listHubs = defineHubController.mostCentralHubs(numberOfHubs, empresaList);
                    for(int x =0; x<listHubs.size(); x++){
                        System.out.println(listHubs.get(x));
                    }

                    break;

                case 4:
                    graph = controller.returnGraph();
                    List<Empresa> empresaList1 = defineHubController.getClosestHubs(graph);
                    List<Hub> hubList = defineHubController.mostCentralHubs(numberOfHubs, empresaList1);
                    Map<Local, Hub> map = defineHubController.getNearestHub(graph, hubList);
                    for(Map.Entry<Local, Hub> en: map.entrySet()) {

                        System.out.println("Client/Prod:"+en.getKey().getType()+"----->"+"Hub:"+en.getValue().getType());

                    }
                    break;

                case 5:
                    graph = controller.returnGraph();
                    List<Local> minDistLis = new ArrayList<>();
                    minDistLis = minDistController.getShortestPath(graph);
                    System.out.println(minDistLis);
                    break;

                case 6:
                    System.out.println("1 - Current System Hour and Day");
                    System.out.println("2 - Selected Hour and Day by user");
                    int option_case6 = Utils.readIntegerFromConsole("Please select the desired option: ");

                    if (option_case6 == 1) {
                        LocalTime currentHour = LocalTime.now();
                        LocalDate currentDate = LocalDate.now();
                        SistemaRegaController.SistemaRegaCtrl(currentHour, currentDate);
                    } else if (option_case6 == 2) {
                        String hour = Utils.readLineFromConsole("Please select the desired hour (24h format): ");
                        LocalTime currentHour = LocalTime.parse(hour);
                        String day = Utils.readLineFromConsole("Please select the desired day (dd-mm-aaaa): ");
                        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate currentDate = LocalDate.parse(day, dateFormat);
                        SistemaRegaController.SistemaRegaCtrl(currentHour, currentDate);
                    } else {
                        System.out.println("Invalid option, please select a valid option.");
                    }

                    break;

                case 7:
                    int optionCabazes = Utils.readIntegerFromConsole("1--- SMALL                  2--- BIG");
                    if(optionCabazes == 1){
                        cabazList=cabazes.readCabazes("cabazes_small.csv");
                    }
                    if (optionCabazes == 2) {
                        cabazList = cabazes.readCabazes("cabazes_big.csv");
                    }

                    System.out.println(cabazList);
                    break;

                case 8:
                    int day;
                    do {
                        day = Utils.readIntegerFromConsole("Please type the desired day");
                        if (day > 5) {
                            System.out.println("Please type a day between 1 and 5");
                        }
                    }
                    while (day > 5);
                    List<Cabaz> clientList1 = expeditionListController.CabazOnTheDay(day, cabazList);
                    List<Cabaz> prodList2 = expeditionListController.ProdByDayAndP(day, cabazList);
                    System.out.println(expeditionListController.expeditionList(prodList2,clientList1));

                    break;

                case 9:
                    int day2;
                    do {
                        day2 = Utils.readIntegerFromConsole("Please type the desired day");
                        if (day2 > 5) {
                            System.out.println("Please type a day between 1 and 5");
                        }
                    }
                    while (day2 > 5);
                    graph = controller.returnGraph();
                    List<Cabaz> clientList2 = expeditionListNHubs.CabazOnTheDay(day2, cabazList);
                    List<Cabaz> prodList3 = expeditionListNHubs.ProdByDayAndP(day2, cabazList);
                    System.out.println(expeditionListNHubs.expeditionListProximity(prodList3,clientList2,graph));

                    break;
                case 10:
                    graph = controller.returnGraph();
                    List<Cabaz> cabazPE = new ArrayList<>();
                    //Remove os Clientes
                    cabazPE = minSizeController.removeClients(cabazList);
                    //Dias dos cabazes
                    Set<Integer> days = new HashSet<Integer>(minSizeController.getDays(cabazPE));
                    for (Integer i : days) {
                        System.out.println("---------------------------------------------------");
                        System.out.println("Dia --> " + i);
                        List<Cabaz> cabazesDay = new ArrayList<>();
                        cabazesDay = minSizeController.CabazesByDay(i, cabazPE);
                        //System.out.println("CAbazes dia-->" + cabazesDay);

                        //Indicar os pontos de passagem do percurso
                        System.out.println("Pontos de passagem do percurso:");
                        System.out.println(minSizeController.getShortest(cabazesDay, graph));

                        //Distancia entre pontos
                        System.out.println(minSizeController.getDistance(graph, cabazesDay));

                    }

                    break;

                case 11:
                    statisticsController.statisticsPerCabaz(cabazList);
                    break;
            }
        }while (option != -1);
        return true;

    }

}