

import app.Model.Length;
import app.controller.InsertGraphController;
import app.controller.MinDistController;
import app.graph.matrix.MatrixGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import app.Model.Local;
import java.util.ArrayList;
import java.util.List;

class MinDistControllerTest {

    MinDistController controller;
    InsertGraphController insertGraphController;


    public MinDistControllerTest(){
        controller = new MinDistController();
        insertGraphController = new InsertGraphController();
    }

    @Test
    void getShortestPath() {
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
        list = controller.getShortestPath(testGraph);
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


}