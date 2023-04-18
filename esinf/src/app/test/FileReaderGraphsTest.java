package app.test;

import app.Model.Length;
import app.Model.Local;
import app.graph.FileReaderGraphs;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderGraphsTest {
    FileReaderGraphs readerGraphs;
    public FileReaderGraphsTest(){
        readerGraphs=new FileReaderGraphs();
    }
    @Test
    void readVerticesInvalid(){
        Throwable resultString = null;
        try {
            List<Local> list =readerGraphs.readVertices("test.csv");
        } catch (Exception ex) {
            resultString = ex.getCause();
        }
        Throwable expectedString = null;

        assertEquals(expectedString, resultString);
    }

    @Test
   void readEdgesInvalid(){
               Throwable resultString = null;
               try {
                   List<Length> list =readerGraphs.readEdges("test.csv");
               } catch (Exception ex) {
                        resultString = ex.getCause();
                    }
                Throwable expectedString = null;

                        assertEquals(expectedString, resultString);
           }
}
