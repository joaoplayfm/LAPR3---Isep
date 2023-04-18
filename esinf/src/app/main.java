package app;

import app.controller.CheckIfConnectedController;
import app.controller.InsertGraphController;
import app.Model.Length;
import app.Model.Local;
import app.graph.FileReaderGraphs;
import app.graph.matrix.MatrixGraph;
import app.ui.MenuUI;


import java.io.IOException;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {


        MenuUI menuUI = new MenuUI();
        menuUI.run();


    }
}
