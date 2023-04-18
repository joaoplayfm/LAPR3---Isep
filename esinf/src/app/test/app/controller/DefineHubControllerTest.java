package app.test.app.controller;

import app.Model.Empresa;
import app.Model.Hub;
import app.Model.Length;
import app.Model.Local;
import app.controller.DefineHubController;
import app.controller.InsertGraphController;
import app.graph.FileReaderGraphs;
import app.graph.matrix.MatrixGraph;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DefineHubControllerTest {

    InsertGraphController insertGraphController;
    FileReaderGraphs fileReaderGraphs;
    DefineHubController defineHubController;

    public DefineHubControllerTest(){
        insertGraphController = new InsertGraphController();
        fileReaderGraphs = new FileReaderGraphs();
        defineHubController = new DefineHubController();

    }

    @org.junit.jupiter.api.Test
    void getClosestHubs() {
        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"C1");
        Local l2 = new Local("id2",15.0,15.0,"C2");
        Local l3 = new Local("id3",20.0,30.0,"E1");
        Local l4 = new Local("id4",30.0,40.0,"P1");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        List<Length> lengthList = new ArrayList<>();
        List<Length> testList = new ArrayList<>();
        Length le1 = new Length("id1","id3",10.0);
        Length le2 = new Length("id2","id3",20.0);
        Length le3 = new Length("id3","id1",0.0);
        Length le4 = new Length("id4","id2",30.0);
        lengthList.add(le1);
        lengthList.add(le2);
        lengthList.add(le3);
        lengthList.add(le4);
        insertGraphController.addVertex(list);
        insertGraphController.addEdges(lengthList);
        MatrixGraph<Local,Double> testGraph = new MatrixGraph<>(false,list.size());
        testGraph = insertGraphController.returnGraph();
        defineHubController.getClosestHubs(testGraph);
        Integer expected = 2;
        Integer result = defineHubController.getClosestHubs(testGraph).size();
        assertEquals(expected,result);
    }

    @org.junit.jupiter.api.Test
    void mostCentralHubs() {

        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"C1");
        Local l2 = new Local("id2",15.0,15.0,"C2");
        Local l3 = new Local("id3",20.0,30.0,"E1");
        Local l4 = new Local("id4",30.0,40.0,"P1");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        List<Length> lengthList = new ArrayList<>();
        List<Length> testList = new ArrayList<>();
        Length le1 = new Length("id1","id3",10.0);
        Length le2 = new Length("id2","id3",20.0);
        Length le3 = new Length("id3","id1",0.0);
        Length le4 = new Length("id4","id2",30.0);
        lengthList.add(le1);
        lengthList.add(le2);
        lengthList.add(le3);
        lengthList.add(le4);
        insertGraphController.addVertex(list);
        insertGraphController.addEdges(lengthList);
        MatrixGraph<Local,Double> testGraph = new MatrixGraph<>(false,list.size());
        testGraph = insertGraphController.returnGraph();
        List<Empresa> empresaList = defineHubController.getClosestHubs(testGraph);
        // insertGraphController.mostCentralHubs(1,empresaList);
        List<Hub> testHubList = new ArrayList<>();
        testHubList.add(new Hub(l3.getId(),l3.getLati(),l3.getLongi(),empresaList.get(0).getCentralDistance(),l3.getType()));
        List<Hub> testHubList2 = new ArrayList<>();
        testHubList2 = defineHubController.mostCentralHubs(1,empresaList);
        String expected = testHubList.toString();
        String result  = testHubList2.toString();
        assertEquals(expected,result);


    }

    @org.junit.jupiter.api.Test
    void getNearestHub() throws IOException {

        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"C1");
        Local l2 = new Local("id2",15.0,15.0,"C2");
        Local l3 = new Local("id3",20.0,30.0,"E1");
        Local l4 = new Local("id4",30.0,40.0,"P1");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        List<Length> lengthList = new ArrayList<>();
        List<Length> testList = new ArrayList<>();
        Length le1 = new Length("id1","id3",10.0);
        Length le2 = new Length("id2","id3",20.0);
        Length le3 = new Length("id3","id1",0.0);
        Length le4 = new Length("id4","id2",30.0);
        lengthList.add(le1);
        lengthList.add(le2);
        lengthList.add(le3);
        lengthList.add(le4);
        insertGraphController.addVertex(list);
        insertGraphController.addEdges(lengthList);
        MatrixGraph<Local,Double> testGraph = new MatrixGraph<>(false,list.size());
        testGraph = insertGraphController.returnGraph();
        List<Empresa> empresaList = defineHubController.getClosestHubs(testGraph);
        List<Hub> testHubList = new ArrayList<>();
        testHubList.add(new Hub(l3.getId(),l3.getLati(),l3.getLongi(),10.0,l3.getType()));
        List<Hub> testHubList2 = new ArrayList<>();
        testHubList2 = defineHubController.mostCentralHubs(1,empresaList);
        Map<Local,Hub> map1 = new HashMap<>();
        Map<Local,Hub> map2 = new HashMap<>();
        map1 = defineHubController.getNearestHub(testGraph,testHubList2);
        map2.put(l1,testHubList.get(0));
        map2.put(l2,testHubList.get(0));
        map2.put(l4,testHubList.get(0));

        System.out.println(map1.toString());
        System.out.println(map2.toString());
        String expected = map2.toString();
        String result  = map1.toString();
        assertEquals(expected,result);




    }
}


