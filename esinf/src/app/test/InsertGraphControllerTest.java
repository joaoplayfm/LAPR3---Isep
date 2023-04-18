package app.test;

import app.Model.Empresa;
import app.Model.Hub;
import app.Model.Length;
import app.Model.Local;
import app.controller.InsertGraphController;
import app.graph.FileReaderGraphs;
import app.graph.matrix.MatrixGraph;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InsertGraphControllerTest {

    InsertGraphController insertGraphController;
    FileReaderGraphs fileReaderGraphs;

    public InsertGraphControllerTest(){
        insertGraphController = new InsertGraphController();
        fileReaderGraphs = new FileReaderGraphs();

    }
    @Test
    void addVertex(){
        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"C1");
        Local l2 = new Local("id2",15.0,15.0,"C2");
        Local l3 = new Local("id3",20.0,30.0,"E1");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        String res= insertGraphController.addVertex(list);
        String exp="3added";
        assertEquals(exp,res);

    }
    @Test
    void addEdges(){
        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"C1");
        Local l2 = new Local("id2",15.0,15.0,"C2");
        list.add(l1);
        list.add(l2);
        insertGraphController.addVertex(list);
        List<Length> lengthList = new ArrayList<>();
        Length le1 = new Length("id1","id2",10.0);
        lengthList.add(le1);
        String res=insertGraphController.addEdges(lengthList);
        String exp="1added";
        assertEquals(exp,res);

    }
    @Test
    void checkKey(){
        List<Local> list = new ArrayList<>();
        Local l1 = new Local("id1",10.0,20.0,"C1");
        Local l2 = new Local("id2",15.0,15.0,"C2");
        Local l3 = new Local("id3",20.0,30.0,"E1");
        Local l4 = new Local("id4",30.0,40.0,"P1");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        insertGraphController.addVertex(list);
        int res= insertGraphController.checkKey("id3");
        int exp=2;
        assertEquals(exp,res);
    }

}



