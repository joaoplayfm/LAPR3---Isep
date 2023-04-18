package app.test;

import app.Model.Cabaz;
import app.controller.ExpeditionListController;
import app.controller.StatisticsController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsControllerTest {

    StatisticsController statisticsController = new StatisticsController();
    ExpeditionListController expeditionListController = new ExpeditionListController();
    @Test
    void statisticsPerCabaz() {
        Cabaz cabaz1 = new Cabaz("C1", 1, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        Cabaz prod1 = new Cabaz("P1", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        List<Cabaz> cabazList = new ArrayList<>();
        cabazList.add(cabaz1);
        cabazList.add(prod1);
        statisticsController.statisticsPerCabaz(cabazList);
    }
}