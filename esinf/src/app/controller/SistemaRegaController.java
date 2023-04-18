package app.controller;

import app.Model.Rega;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Controller for US306 for ESINF
 */
public class SistemaRegaController {

    /**
     * Read file rega.csv and returns a linked hash map with the results.
     *
     * @return the linked hash map with the results of the read file
     * @throws IOException the io exception
     */
    public static LinkedHashMap<Rega, LocalTime[]> readFileRega() throws IOException {
        FileReader readFile = new FileReader("rega.csv");
        String line;
        double daysActive;
        LinkedHashMap<Rega, LocalTime[]> fileRead = new LinkedHashMap<>();
        Rega rega;
        BufferedReader bufferedReader = new BufferedReader(readFile);
        String[] hoursActiveArr = bufferedReader.readLine().split(",");
        LocalTime[] hoursActiveDate = new LocalTime[hoursActiveArr.length];
        for (int i = 0; i < hoursActiveArr.length; i++) {
            hoursActiveDate[i] = LocalTime.parse(hoursActiveArr[i]);
        }
        for (LocalTime d : hoursActiveDate) {
            System.out.println(d.getMinute() + d.getHour() * 60);
        }

        while ((line = bufferedReader.readLine()) != null) {
            String[] info = line.split(",");
            if (info[2].equals("p"))
                daysActive = 2.0;
            else {
                if (info[2].equals("i"))
                    daysActive = 3.0;
                else
                    daysActive = 1.0;
            }

            rega = new Rega(info[0], Double.parseDouble(info[1]), daysActive);

            fileRead.put(rega, hoursActiveDate);
        }
        readFile.close();
        return fileRead;
    }

    /**
     * Gets the results from the last method and checks if the system is on or off.
     *
     * @throws IOException the io exception
     */
    public static void SistemaRegaCtrl(LocalTime currentHour, LocalDate currentDate) throws IOException {
        System.out.println(currentHour);
        System.out.println(currentDate);
        LinkedHashMap<Rega, LocalTime[]> rega = readFileRega();
        Map.Entry<Rega, LocalTime[]> entry = rega.entrySet().iterator().next();
        LocalTime[] activeHours = entry.getValue();
        Set<Rega> setKeys = rega.keySet();
        Rega[] regaArr = setKeys.toArray(new Rega[0]);

        for (Rega value : regaArr) {
            for (int j = 0; j < activeHours.length - 1; j++) {
                double currentHourMin = currentHour.getHour() * 60 + currentHour.getMinute();
                double activeHourMin = activeHours[j].getHour() * 60 + activeHours[j].getMinute()-1;
                if (currentDate.getDayOfMonth() % 2 == 0) {
                    if (value.id_rega_diaria == 1 || value.id_rega_diaria == 2) {
                        if (activeHourMin < currentHourMin && currentHourMin < value.quantidade + activeHourMin) {
                            System.out.printf("Parcela: %s\n   Estado: Ativo\n   Tempo Restante: %.0fmin\n\n", value.parcela, value.quantidade + activeHourMin - currentHourMin);
                        } else {
                            System.out.printf("Parcela: %s\n   Estado: Desativado\n\n", value.parcela);
                        }
                    } else {
                        System.out.printf("Parcela: %s\n   Estado: Desativado\n\n", value.parcela);

                    }
                } else {
                    if (value.id_rega_diaria == 1 || value.id_rega_diaria == 3) {
                        if (activeHourMin < currentHourMin || currentHourMin < value.quantidade + activeHourMin) {
                            System.out.printf("Parcela: %s\n   Estado: Ativo\n   Tempo Restante: %.0fmin\n\n", value.parcela, value.quantidade + activeHourMin - currentHourMin);
                        } else {
                            System.out.printf("Parcela: %s\n   Estado: Desativado\n\n", value.parcela);
                        }
                    } else {
                        System.out.printf("Parcela: %s\n   Estado: Desativado\n\n", value.parcela);
                    }
                }
            }
        }
    }
}