package com.calculatriceimt.controler;

import java.util.List;

import com.calculatriceimt.View.CalculatorGUI;
import com.calculatriceimt.model.CalculatorModel;


public class CalculatorControler implements CalculatorControlerInterface {
    CalculatorModel model;
    CalculatorGUI view;

    public CalculatorControler(CalculatorModel model, CalculatorGUI view)
    {
        this.model = model;
        this.view = view;
    }

    @Override
    public void change(Double accu)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'change'");
    }
    @Override
    public void change(List<Double> stackData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'change'");
    }
}
