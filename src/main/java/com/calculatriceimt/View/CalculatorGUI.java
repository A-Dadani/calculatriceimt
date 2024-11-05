package com.calculatriceimt.View;

import java.util.List;

import com.calculatriceimt.controler.CalculatorControler;
import com.calculatriceimt.model.CalculatorModel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * JavaFX App
 */
public class CalculatorGUI extends Application implements CalculatorGUIInterface {

    // Declarer le model et le controleur (listener) associé à la view
    CalculatorModel model = null;
    CalculatorControler listener = null;
    

    private static Scene scene;
    
    // Déclaration des elements graphiques (voir les IDs dans CalculatriceGUI.fxml)
    @FXML
    private Label accuLabel;
    @FXML
    private Label stackLabel1;
    @FXML
    private Label stackLabel2;
    @FXML
    private Label stackLabel3;
    @FXML
    private Label stackLabel4;
    @FXML
    private Button CACButton;
    

    public CalculatorGUI()
    {
        // Initialiser le model et le controlleur
        model = new CalculatorModel();
        listener = new CalculatorControler(model, this);
        // Ajouter le listener (le controler) au model pour qu'il puisse 'notifier' le controller lui aussi
        model.addListener(listener);
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("CalculatriceGUI"), 500, 912);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorGUI.class.getResource("/com/calculatriceimt/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    @Override
    public void affiche() {
        launch();
    }

    @FXML
    public void appuieBoutton(ActionEvent event)
    {
        Button button = (Button) event.getSource(); // Pour avoir le boutton qui a declancher l'evenement
        String value = button.getText(); // Lire le text du boutton
        listener.changeFromUserInput(value); // Envoyer la notification au controller
    }

    @Override
    public void change(String accu) {
        // Si l'accumulateur est nul, on n'affiche rien, et on chance le boutton Clear (C) pour devenir All Clear (AC)
        if (accu == null)
        {
            accuLabel.setText("");
            CACButton.setText("AC");
        }
        else // Sinon on mets (C)
        {
            accuLabel.setText(accu);
            CACButton.setText("C");
        }
    }

    @Override
    public void change(List<String> stackData) {
        // On s'assure que la taille de la pile est suffisante pour être affichée avant de l'afficher.
        stackLabel1.setText(stackData.size() > 3 ? stackData.get(stackData.size() - 4) : "");
        stackLabel2.setText(stackData.size() > 2 ? stackData.get(stackData.size() - 3) : "");
        stackLabel3.setText(stackData.size() > 1 ? stackData.get(stackData.size() - 2) : "");
        stackLabel4.setText(stackData.size() > 0 ? stackData.get(stackData.size() - 1) : "");
    }
}
