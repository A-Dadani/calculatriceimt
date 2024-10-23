package com.calculatriceimt.model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {

    private Stack<Double> pile = new Stack<Double>();
    private Double accu = null;

    // TODO Constructeur? à mediter
    // TODO à mediter, config javaFX?
    // TODO à mediter: faire une fonction pour eviter les copier coller

    @Override
    public void add() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            // TODO à mediter, err à preciser?
            if (pile.size() < 2) throw new Exception("ERR");
            
            // L'opération est possible
            Double resultat = pile.pop() + pile.pop();
            pile.push(resultat);
            accu = null;
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            // TODO à mediter, err à preciser?
            if (pile.isEmpty()) throw new Exception("ERR");
            Double resultat = accu + pile.pop();
            pile.push(resultat);
            accu = null;
        }
    }

    // TODO REMOVE TEMPORAIRE
    public CalculatorModel()
    {
        pile.push(10.0);
        pile.push(0.0);
        pile.push(4.0);
    }

    public Double GetAcc()
    {
        return accu;
    }
    /////////////////////////////////////////



    @Override
    public void substract() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            // TODO à mediter, err à preciser?
            if (pile.size() < 2) throw new Exception("ERR");
            
            // L'opération est possible
            pile.push(-pile.pop() + pile.pop());
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            // TODO à mediter, err à preciser?
            if (pile.isEmpty()) throw new Exception("ERR");
            pile.push(pile.pop() - accu);
            accu = null;
        }
    }

    @Override
    public void multiply() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            // TODO à mediter, err à preciser?
            if (pile.size() < 2) throw new Exception("ERR");
            
            // L'opération est possible
            pile.push(pile.pop() * pile.pop());
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            // TODO à mediter, err à preciser?
            if (pile.isEmpty()) throw new Exception("ERR");
            pile.push(accu * pile.pop()); 
            accu = null;
        }
    }

    @Override
    public void divide() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            // TODO à mediter, err à preciser?
            if (pile.size() < 2) throw new Exception("ERR");
            
            // L'opération est possible
            // Puisqu'on doit diviser le nombre n-1 par n, on utilise
            // des variables temporaires
            Double rhs = pile.pop();
            Double lhs = pile.pop();

            // Traiter le cas de div par 0
            if (rhs == 0) throw new Exception("Division par 0 impossible!");
            pile.push(lhs / rhs);
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            // TODO à mediter, err à preciser?
            if (pile.isEmpty()) throw new Exception("ERR");

            // Traiter le cas de div par 0
            if (accu == 0) throw new Exception("Division par 0 impossible!");
            pile.push(pile.pop() / accu);
            accu = null;
        }
    }

    @Override
    public void opposite() throws Exception {
        if (accu == null) throw new Exception("Accumulateur vide!");
        accu = -accu;
    }

    @Override
    public void push() throws Exception {
        if (accu == null) throw new Exception("Accumulateur vide!");
        pile.push(accu);
        accu = null;
    }

    @Override
    public void pop() throws Exception {
        if (pile.isEmpty()) throw new Exception("Pile vide!");
        accu = pile.pop();
    }

    @Override
    public void drop() throws Exception {
        if (pile.isEmpty()) throw new Exception("Pile vide!");
        pile.pop();
    }

    @Override
    public void swap() throws Exception {
        // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
        if (pile.size() < 2) throw new Exception("ERR");

        // On utilise une variable temporaire pour echanger les elements
        Double tempNew = pile.pop();
        Double tempOld = pile.pop();
        pile.push(tempNew);
        pile.push(tempOld);
    }

    @Override
    public void clear() {
        accu = null;
    }

    public void Aclear() {
        accu = null;
        while (!pile.isEmpty()) pile.pop();
    }

}
