package org.example.ratioedt;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private VBox eventList;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void initialize() throws IOException {
        EDTParser parser = new EDTParser();
        String test = "https://edt-api.univ-avignon.fr/api/exportAgenda/salle/def50200acc876b4f83421bf14bd6a4206930d9c55f08e26da9d906f0603e204d530dbac72d5627bf697b21cae8a1889963574d4120b98b2201e459f6e566f04038636d979f8749b2e007880e1c0b76e887535985914cee497bc76";
        EmploiDuTemps edt = parser.parseEDT(test);
        for(Evenement event: edt.getEvents()){
            eventList.getChildren().add(new Label(event.getDescription()));
        }
        // System.out.println(edt);
    }
}