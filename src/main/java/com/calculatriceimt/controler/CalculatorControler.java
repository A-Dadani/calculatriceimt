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

    // Quand un changement provient du model
    @Override
    public void change(String accu)
    {
        view.change(accu);
    }

    // Quand un changement provient du model
    @Override
    public void change(List<Double> stackData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'change'");
    }

    // Quand un changement provient de l'interface graphique
    // L'argument input est necessairement soit une virgule soit un chiffre.
    public void changeFromUserInput(String input)
    {
        switch (input)
        {
            case "AC":
                break;
            case "🡑":
                break;
            case "+":
                break;
            case "-":
                break;
            case "×":
                break;
            case "➗":
                break;
            case "+/-":
            {
                try {
                    model.opposite();
                } catch (Exception e) {} // Si accumulateur est vide ne rien faire
                break;
            }
            case "🡙":
                break;
            case "🠨":
                break;
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
