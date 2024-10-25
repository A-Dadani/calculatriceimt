package com.calculatriceimt;

import java.io.IOException;

import com.calculatriceimt.View.CalculatorGUI;

import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        CalculatorGUI.setRoot("secondary");
    }
}
