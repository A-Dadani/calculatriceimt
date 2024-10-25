package com.calculatriceimt;

import java.io.IOException;

import com.calculatriceimt.View.CalculatorGUI;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        CalculatorGUI.setRoot("primary");
    }
}