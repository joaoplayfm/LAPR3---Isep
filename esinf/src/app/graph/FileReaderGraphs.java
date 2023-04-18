package app.graph;

import app.Model.Length;
import app.Model.Local;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderGraphs {

    public  List<Local> readVertices(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        int k=0;
        List<Local> list = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if(k==0){
                String[] info = line.split(",");
                k=1;
            }
            else {
            String[] info = line.split(",");
            list.add(new Local(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), info[3]));}
        }
        reader.close();
        return list;
    }
    public  List<Length> readEdges(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        int k=0;
        List<Length> list = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if(k==0){
                String[] info = line.split(",");
                k=1;
            }
            else {
                String[] info = line.split(",");
                list.add(new Length(info[0],info[1], Double.parseDouble(info[2])));}
        }
        reader.close();
        return list;
    }
}
