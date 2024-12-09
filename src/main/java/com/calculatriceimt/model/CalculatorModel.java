package com.calculatriceimt.model;

import java.util.*;

import com.calculatriceimt.controler.CalculatorControler;

public class CalculatorModel implements CalculatorModelInterface {
    private Stack<Double> pile = new Stack<Double>();
    private String accu = null;
    private CalculatorControler listener = null; // Listener pour pouvoir "notifier" le controlleur

    public String GetAccu()
    {
        return accu;
    }

    public void addListener(CalculatorControler listener)
    {
        // Initialiser le listener
        this.listener = listener;
    }

    @Override
    public void add() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            if (pile.size() < 2) throw new Exception("Pile trop petite!");
            
            // L'opération est possible
            Double resultat = mPop() + mPop();
            mPush(resultat);
            SetAccu(null);
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            if (pile.isEmpty()) throw new Exception("Pile trop petite!");
            Double resultat = Double.parseDouble(accu) + mPop();
            mPush(resultat);
            SetAccu(null);
        }
    }


    @Override
    public void substract() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            if (pile.size() < 2) throw new Exception("Pile trop petite!");
            
            // L'opération est possible
            mPush(-mPop() + mPop());
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            if (pile.isEmpty()) throw new Exception("Pile trop petite!");
            mPush(mPop() - Double.parseDouble(accu));
            SetAccu(null);
        }
    }

    @Override
    public void multiply() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            if (pile.size() < 2) throw new Exception("Pile trop petite!");
            
            // L'opération est possible
            mPush(mPop() * mPop());
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            if (pile.isEmpty()) throw new Exception("Pile trop petite!");
            mPush(Double.parseDouble(accu) * mPop()); 
            SetAccu(null);
        }
    }

    @Override
    public void divide() throws Exception {
        if (accu == null)
        {
            // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
            if (pile.size() < 2) throw new Exception("Pile trop petite!");
            
            // L'opération est possible
            // Puisqu'on doit diviser le nombre n-1 par n, on utilise
            // des variables temporaires
            Double rhs = mPop();
            Double lhs = mPop();

            // Traiter le cas de div par 0
            if (rhs == 0) throw new Exception("Division par 0!");
            mPush(lhs / rhs);
        }
        else
        {
            // L'accumulateur n'est pas vide, et il faut utiliser son contenu avec le dernier élément sur la pile
            if (pile.isEmpty()) throw new Exception("Pile trop petite!");

            // Traiter le cas de div par 0
            if (Double.parseDouble(accu) == 0.0) throw new Exception("Division par 0!");
            mPush(mPop() / Double.parseDouble(accu));
            SetAccu(null);
        }
    }

    @Override
    public void opposite() throws Exception {
        if (accu == null) throw new Exception("Accumulateur vide!");
        if (Double.parseDouble(accu) == 0.0) return; // l'opposé de 0 est 0 
        Double tempAccu = -Double.parseDouble(accu); // Transformer le string en double pour l'inverser
        SetAccu(tempAccu == tempAccu.intValue() ? String.format("%.0f", tempAccu) : tempAccu.toString()); // S'il y a des 0 après la virgule, il faut les enlever
    }

    @Override
    public void push() throws Exception {
        if (accu == null) throw new Exception("Accumulateur vide!");
        mPush(Double.parseDouble(accu));
        SetAccu(null);
    }

    @Override
    public void pop() throws Exception {
        if (pile.isEmpty()) throw new Exception("Pile vide!");
        SetAccu(mPop().toString());
    }

    @Override
    public void drop() throws Exception {
        if (pile.isEmpty()) throw new Exception("Pile vide!");
        mPop();
    }

    @Override
    public void swap() throws Exception {
        // Si l'accumulateur est vide, on utilise les 2 derniers éléments dans la pile
        if (pile.size() < 2) throw new Exception("Pile trop petite!");

        // On utilise une variable temporaire pour echanger les elements
        Double tempNew = mPop();
        Double tempOld = mPop();
        mPush(tempNew);
        mPush(tempOld);
    }

    @Override
    public void clear() {
        SetAccu(null);
    }

    public void Aclear() {
        SetAccu(null);
        while (!pile.isEmpty()) mPop();
    }

    
    // Des fontions push & pop pour être sur qu'on notifie le controller avant de modifier la pile
    private void mPush(Double in)
    {
        pile.push(in);
        List<Double> pileList = new ArrayList<Double>(pile);
        listener.change(pileList);
    }
    
    private Double mPop()
    {
        Double val = pile.pop();
        List<Double> pileList = new ArrayList<Double>(pile);
        listener.change(pileList);
        return val;
    }

    // Notifier le controller après tout changement de la valeur d'accu
    public void SetAccu(String accu)
    {
        this.accu = accu;
        listener.change(accu);
    }
}
