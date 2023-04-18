package app.test;

import app.Model.Cabaz;
import app.graph.FileReaderCabazes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderCabazesTest {

    FileReaderCabazes reader;

    public FileReaderCabazesTest() {
        reader = new FileReaderCabazes();

    }

    @Test
    void readCabazesInvalid() {
        Throwable resultString = null;
        try {
            List<Cabaz> list = reader.readCabazes("test.csv");
        } catch (Exception ex) {
            resultString = ex.getCause();
        }
        Throwable expectedString = null;
        assertEquals(expectedString, resultString);
    }


}
