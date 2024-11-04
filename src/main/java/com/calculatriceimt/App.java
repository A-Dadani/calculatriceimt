package com.calculatriceimt;

import com.calculatriceimt.View.CalculatorGUI;

import javafx.scene.text.Font;

/**
 * JavaFX App
 */
public class App {
    public static void main(String[] args) {
        // S'assurer que les polices sont bien importées
        Font.loadFont(App.class.getResource("fonts/ProductSans-Black.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-BlackItalic.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-Bold.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-BoldItalic.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-Italic.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-Light.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-LightItalic.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-Medium.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-MediumItalic.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-Regular.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-Thin.ttf").toExternalForm(), 10);
        Font.loadFont(App.class.getResource("fonts/ProductSans-ThinItalic.ttf").toExternalForm(), 10);



        CalculatorGUI view = new CalculatorGUI();
        view.affiche();
    }

}