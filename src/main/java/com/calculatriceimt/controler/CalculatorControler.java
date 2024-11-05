package com.calculatriceimt.controler;

import java.util.List;
import java.util.stream.Collectors;

import com.calculatriceimt.View.CalculatorGUI;
import com.calculatriceimt.model.CalculatorModel;


public class CalculatorControler implements CalculatorControlerInterface {
    CalculatorModel model;
    CalculatorGUI view;

    public CalculatorControler(CalculatorModel model, CalculatorGUI view)
    {
        // On enregistre une reference au model et à la view pour que l'on puisse les 'notifier'
        this.model = model;
        this.view = view;
    }

    // Quand un changement provient du model
    @Override
    public void change(String accu)
    {
        view.change(accu);
    }

    // Quand un changement provient du model
    @Override
    public void change(List<Double> stackData) {
        // On change la liste des doubles en liste de chaines de caractère, en supprimant les 0 après la virgule
        List<String> strings = stackData.stream()
            .map(d -> d == d.intValue() ? String.format("%.0f", d) : d.toString())
            .collect(Collectors.toList());
        view.change(strings);
    }

    // Quand un changement provient de l'interface graphique
    // L'argument input est necessairement soit une virgule soit un chiffre.
    public void changeFromUserInput(String input)
    {

        // On traite le input de l'utilisateur
        switch (input)
        {
            case "AC":
                model.Aclear();
                break;
            case "C":
                model.clear();
                break;
            case "🡑":
            {
                try {
                    model.push();
                } catch (Exception e) {
                    view.change(e.getMessage());
                }
                break;
            }
            case "+":
                try {
                    model.add();
                } catch (Exception e) {
                    view.change(e.getMessage());
                }
                break;
            case "-":
                try {
                    model.substract();
                } catch (Exception e) {
                    view.change(e.getMessage());
                }
                break;
            case "×":
                try {
                    model.multiply();
                } catch (Exception e) {
                    view.change(e.getMessage());
                }
                break;
            case "➗":
                try {
                    model.divide();
                } catch (Exception e) {
                    view.change(e.getMessage());
                }
                break;
            case "+/-":
            {
                try {
                    model.opposite();
                } catch (Exception e) {}  // Si accumulateur est vide ne rien faire
                break;
            }
            case "🡙":
                try {
                    model.swap();
                } catch (Exception e) {
                    view.change(e.getMessage());
                }
                break;
            case "🠨":
            {
                // Si accumulateur est déja vide ou si il n'y a qu'un seul chiffre (positif ou negatif)
                if (model.GetAccu() == null 
                    || model.GetAccu().length() == 1
                    || (model.GetAccu().charAt(0) == '-') && model.GetAccu().length() == 2)
                {
                    model.SetAccu(null);
                } 
                else
                {
                    model.SetAccu(model.GetAccu().substring(0, model.GetAccu().length() - 1));
                }

                break;
            }
            case ",":
            {
                if (model.GetAccu() == null) model.SetAccu("0"); // Si l'accumulateur est null est que l'utilisateur appuie sur ',' on veut afficher '0,'

                // On regarde ce qu'il y a dans l'accumulateur
                String strAccu = model.GetAccu();

                // verifier si le nombre ne comporte pas déjà une virgule
                // La fonction indexOf() retourne -1 si le caractère n'est pas dans la chaine
                if (strAccu.indexOf('.') != -1) return; // Il y a deja une virgule, ne rien faire.
                model.SetAccu(strAccu + ".");
                break;
            }
            default: // c'est un chiffre
            {
                if (model.GetAccu() == null || model.GetAccu().equals("0")) model.SetAccu(input);
                else model.SetAccu(model.GetAccu() + input);
            }                
        }
    }
}
