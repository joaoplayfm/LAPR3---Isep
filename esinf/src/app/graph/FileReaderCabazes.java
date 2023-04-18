package app.graph;

import app.Model.Cabaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCabazes {
    public List<Cabaz> readCabazes(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        String id = null;
        int k = 0;
        List<Cabaz> cabazes = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (k == 0) {
                String[] info = line.split(",");
                k = 1;
            } else {

                String[] info = line.split(",");
                if (info[0].charAt(0) == '\"' && info[0].charAt(info[0].length() - 1) == '\"') {
                    id = info[0].substring(1, info[0].length() - 1);
                } else id = info[0];
                if (filename.contains("small")) {

                    cabazes.add(new Cabaz(id, Integer.parseInt(info[1]), Double.parseDouble(info[2]), Double.parseDouble(info[3]), Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]), Double.parseDouble(info[7]), Double.parseDouble(info[8]), Double.parseDouble(info[9]), Double.parseDouble(info[10]), Double.parseDouble(info[11]), Double.parseDouble(info[12]), Double.parseDouble(info[13])));
                }
                else cabazes.add(new Cabaz(id, Integer.parseInt(info[1]), Double.parseDouble(info[2]), Double.parseDouble(info[3]), Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]), Double.parseDouble(info[7]), Double.parseDouble(info[8]), Double.parseDouble(info[9]), Double.parseDouble(info[10]), Double.parseDouble(info[11]), Double.parseDouble(info[12]), Double.parseDouble(info[13]),Double.parseDouble(info[14]),Double.parseDouble(info[15]),Double.parseDouble(info[16]),Double.parseDouble(info[17]),Double.parseDouble(info[18]),Double.parseDouble(info[19]),Double.parseDouble(info[20]),Double.parseDouble(info[21])));

            }
        }
        return cabazes;
    }
}
