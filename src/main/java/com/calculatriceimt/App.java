package com.calculatriceimt;

import com.calculatriceimt.View.CalculatorGUI;
import com.calculatriceimt.controler.CalculatorControler;
import com.calculatriceimt.model.CalculatorModel;

/**
 * JavaFX App
 */
public class App {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorGUI view = new CalculatorGUI();
        CalculatorControler controler = new CalculatorControler(model, view);
        view.affiche();
    }

}