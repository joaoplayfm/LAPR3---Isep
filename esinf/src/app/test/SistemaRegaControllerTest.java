

/*
import app.Model.Rega;
import app.controller.SistemaRegaController;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class SistemaRegaControllerTest {

    @Test
    void readFileRegaShouldThrowExceptionWhenFileDoesNotExist() {
        String fileName = "test.txt";
        assertThrows(IOException.class, () -> SistemaRegaController.readFileRega(fileName));
    }

    @Test
    void readFileRegaShouldReturnLinkedHashMapWithCorrectValues() {
        String fileName = "rega.csv";
        LinkedHashMap<Rega, LocalTime[]> expected = new LinkedHashMap<>();
        Rega rega = new Rega("a", 10.0, 1.0);
        Rega rega1 = new Rega("b", 12.0, 2.0);
        Rega rega2 = new Rega("c", 12.0, 3.0);
        LocalTime[] hoursActiveDate = {
                LocalTime.parse("16:37"), LocalTime.parse("17:00")
        };
        expected.put(rega, hoursActiveDate);
        expected.put(rega1, hoursActiveDate);
        expected.put(rega2, hoursActiveDate);

        LinkedHashMap<Rega, LocalTime[]> actual = new LinkedHashMap<>();
        actual.put(rega, hoursActiveDate);
        actual.put(rega1, hoursActiveDate);
        actual.put(rega2, hoursActiveDate);
        assertEquals(expected, actual);
    }
}*/
