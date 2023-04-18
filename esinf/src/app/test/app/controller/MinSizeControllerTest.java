package app.test.app.controller;

import app.Model.Cabaz;
import app.Model.Empresa;
import app.Model.Length;
import app.Model.Local;
import app.controller.InsertGraphController;
import app.controller.MinDistController;
import app.controller.MinSizeController;
import app.graph.matrix.MatrixGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class MinSizeControllerTest {

    MinSizeController controller;
    InsertGraphController insertGraphController;


    public MinSizeControllerTest(){
        controller = new MinSizeController();
        insertGraphController = new InsertGraphController();
    }

    @Test
    void cabazesByDay() {
        List<Cabaz> cabazs = new ArrayList<>();
        Cabaz c1 = new Cabaz("E1", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c2 = new Cabaz("E2", 2, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c3 = new Cabaz("P3", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c4 = new Cabaz("E4", 5, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        cabazs.add(c1);
        cabazs.add(c2);
        cabazs.add(c3);
        cabazs.add(c4);
        cabazs = controller.CabazesByDay(5, cabazs);
        List<Cabaz> result = cabazs;
        List<Cabaz> expectd = cabazs;
        Assertions.assertEquals(expectd, result);
        System.out.println("--------------------------");
        System.out.print("result --> ");
        System.out.println(result);
        System.out.print("Expected --> ");
        System.out.println(expectd);
        System.out.println("--------------------------");
    }

    @Test
    void getDays() {
        List<Cabaz> cabazs = new ArrayList<>();
        Cabaz c1 = new Cabaz("E1", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c2 = new Cabaz("E2", 2, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c3 = new Cabaz("P3", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c4 = new Cabaz("E4", 5, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        cabazs.add(c1);
        cabazs.add(c2);
        cabazs.add(c3);
        cabazs.add(c4);
        Set<Integer> days = new HashSet<>();
        days = controller.getDays(cabazs);
        Set<Integer> result = days;
        Set<Integer> expectd = days;
        Assertions.assertEquals(expectd, result);
        System.out.println("--------------------------");
        System.out.print("result --> ");
        System.out.println(result);
        System.out.print("Expected --> ");
        System.out.println(expectd);
        System.out.println("--------------------------");
    }

    @Test
    void removeClients() {
        List<Cabaz> cabazs = new ArrayList<>();
        Cabaz c1 = new Cabaz("E1", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c2 = new Cabaz("E2", 2, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c3 = new Cabaz("P3", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c4 = new Cabaz("E4", 5, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        cabazs.add(c1);
        cabazs.add(c2);
        cabazs.add(c3);
        cabazs.add(c4);
        cabazs = controller.removeClients(cabazs);
        List<Cabaz> result = cabazs;
        List<Cabaz> expectd = cabazs;
        Assertions.assertEquals(expectd, result);
        System.out.println("--------------------------");
        System.out.print("result --> ");
        System.out.println(result);
        System.out.print("Expected --> ");
        System.out.println(expectd);
        System.out.println("--------------------------");
    }

    @Test
    void getDayGraph() {
        List<Cabaz> cabazs = new ArrayList<>();
        Cabaz c1 = new Cabaz("E1", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c2 = new Cabaz("E2", 2, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c3 = new Cabaz("P3", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c4 = new Cabaz("E4", 5, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        cabazs.add(c1);
        cabazs.add(c2);
        cabazs.add(c3);
        cabazs.add(c4);
        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"E1");
        Local l2 = new Local("id2",15.0,15.0,"E2");
        Local l3 = new Local("id3",20.0,30.0,"P1");
        Local l4 = new Local("id4",30.0,40.0,"P2");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        List<Length> lengthList = new ArrayList<>();
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
        testGraph = controller.getDayGraph(testGraph, cabazs);
        MatrixGraph<Local, Double> result = testGraph;
        MatrixGraph<Local, Double> expectd = testGraph;
        Assertions.assertEquals(expectd, result);
        System.out.println("--------------------------");
        System.out.print("result --> ");
        System.out.println(result);
        System.out.print("Expected --> ");
        System.out.println(expectd);
        System.out.println("--------------------------");

    }

    @Test
    void getShortest() {
        List<Cabaz> cabazs = new ArrayList<>();
        Cabaz c1 = new Cabaz("E1", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c2 = new Cabaz("E2", 2, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c3 = new Cabaz("P3", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c4 = new Cabaz("E4", 5, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        cabazs.add(c1);
        cabazs.add(c2);
        cabazs.add(c3);
        cabazs.add(c4);
        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"E1");
        Local l2 = new Local("id2",15.0,15.0,"E2");
        Local l3 = new Local("id3",20.0,30.0,"P1");
        Local l4 = new Local("id4",30.0,40.0,"P2");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        List<Length> lengthList = new ArrayList<>();
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
        list = controller.getShortest(cabazs, testGraph);
        List<Local> result = list;
        List<Local> expectd = list;
        Assertions.assertEquals(expectd, result);
        System.out.println("--------------------------");
        System.out.print("result --> ");
        System.out.println(result);
        System.out.print("Expected --> ");
        System.out.println(expectd);
        System.out.println("--------------------------");
    }

    @Test
    void getDistance() {
        List<Cabaz> cabazs = new ArrayList<>();
        Cabaz c1 = new Cabaz("E1", 1, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c2 = new Cabaz("E2", 2, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c3 = new Cabaz("P3", 2, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        Cabaz c4 = new Cabaz("E4", 5, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 7.5, 2.0, 3.0);
        cabazs.add(c1);
        cabazs.add(c2);
        cabazs.add(c3);
        cabazs.add(c4);
        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"E1");
        Local l2 = new Local("id2",15.0,15.0,"E2");
        Local l3 = new Local("id3",20.0,30.0,"P1");
        Local l4 = new Local("id4",30.0,40.0,"P2");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        List<Empresa> list2 = new ArrayList<>();
        Empresa e1 = new Empresa("id1",10.0,20.0, 1996146.0,"E1");
        Empresa e2 = new Empresa("id2",15.0,15.0, 3217884.0, "E2");
        Empresa e3 = new Empresa("id3",20.0,30.0, 15.0, "P1");
        Empresa e4 = new Empresa("id4",30.0,40.0, 19.0,"P2");
        list2.add(e1);
        list2.add(e2);
        list2.add(e3);
        list2.add(e4);
        List<Length> lengthList = new ArrayList<>();
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
        list2 = controller.getDistance(testGraph, cabazs);
        List<Empresa> result = list2;
        List<Empresa> expectd = list2;
        Assertions.assertEquals(expectd, result);
        System.out.println("--------------------------");
        System.out.print("result --> ");
        System.out.println(result);
        System.out.print("Expected --> ");
        System.out.println(expectd);
        System.out.println("--------------------------");
    }
}