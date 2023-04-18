package app.test.app.controller;

import app.Model.Cabaz;
import app.controller.ExpeditionListNHubs;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpeditionListNHubsTest {


    ExpeditionListNHubs controller;


    public ExpeditionListNHubsTest() {
        controller = new ExpeditionListNHubs();
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
}
