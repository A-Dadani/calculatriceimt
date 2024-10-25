package com.calculatriceimt.controler;

import java.util.List;

import com.calculatriceimt.model.CalculatorModel;

public class CalculatorControler implements CalculatorControlerInterface {
    CalculatorModel model;

    CalculatorControler(CalculatorModel model)
    {
        this.model = model;
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
