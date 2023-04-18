package app.test.app.controller;

import app.Model.Cabaz;
import app.controller.ExpeditionListController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ExpeditionListControllerTest {

    ExpeditionListController controller;

    public ExpeditionListControllerTest() {
        controller = new ExpeditionListController();
    }

    @Test
    void cabazOnTheDay() {
        List<Cabaz> expected = new ArrayList<>();
        Cabaz c2 = new Cabaz("P1", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c3 = new Cabaz("C1", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c4 = new Cabaz("C3", 2, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c5 = new Cabaz("C2", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        expected.add(c3);
        expected.add(c5);
        List<Cabaz> result = controller.CabazOnTheDay(1, expected);
        assertEquals(expected, result);


    }

    @Test
    void prodByDayAndP() {
        List<Cabaz> expected = new ArrayList<>();
        Cabaz c2 = new Cabaz("P1", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c3 = new Cabaz("P2", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c4 = new Cabaz("C3", 2, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c5 = new Cabaz("C2", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        expected.add(c3);
        expected.add(c2);
        List<Cabaz> result = controller.ProdByDayAndP(1, expected);
        assertEquals(expected, result);

    }

    @Test
    void expeditionList() {
        List<Cabaz> fullList = new ArrayList<>();
        Cabaz c2 = new Cabaz("P1", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c3 = new Cabaz("P2", 2, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c4 = new Cabaz("C3", 2, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        Cabaz c5 = new Cabaz("C2", 1, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        fullList.add(c2);
        fullList.add(c3);
        fullList.add(c4);
        fullList.add(c5);
        List<Cabaz> prodList = controller.ProdByDayAndP(1, fullList);
        List<Cabaz> clientList = controller.CabazOnTheDay(1, fullList);

        Map<String, Map<String, Double>> expected = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            Map<String, Double> partialMap = new HashMap<>();
            partialMap.put(c2.getId(), c2.getProdGeneric(i));
            expected.put("Cliente:" + c5.getId() + "  " + "Produto:" + i, partialMap);
        }
        Map<String, Map<String, Double>> result = controller.expeditionList(prodList, clientList);
        assertEquals(expected, result);


    }
}
