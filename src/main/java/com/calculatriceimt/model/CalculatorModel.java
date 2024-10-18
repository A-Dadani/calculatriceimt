package com.calculatriceimt.model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {

    private Stack<Float> pile = new Stack<Float>();
    private Float accu = null;

    // TODO Constructeur? à mediter
    // TODO à mediter, config javaFX?

    @Override
    public void add() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            // TODO à mediter, err à preciser?
            if (pile.size() < 2) throw new Exception("ERR");
            
            // L'opération est possible
            accu = pile.pop() + pile.pop();
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            // TODO à mediter, err à preciser?
            if (pile.isEmpty()) throw new Exception("ERR");
            accu += pile.pop();
        }
    }

    // TODO REMOVE TEMPORAIRE
    public CalculatorModel()
    {
        pile.push(3f);
        pile.push(4f);
        pile.push(5f);
    }

    public Float GetAcc()
    {
        return accu;
    }

    @Override
    public void substract() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'substract'");
    }

    @Override
    public void multiply() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'multiply'");
    }

    @Override
    public void divide() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'divide'");
    }

    @Override
    public void opposite() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'opposite'");
    }

    @Override
    public void push() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'push'");
    }

    @Override
    public void pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public void drop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drop'");
    }

    @Override
    public void swap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'swap'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

}
