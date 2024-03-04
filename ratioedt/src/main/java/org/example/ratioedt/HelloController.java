package org.example.ratioedt;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class HelloController {

    @FXML
    private VBox eventList;

    @FXML
    protected void initialize() throws IOException {

        EDTParser parser = new EDTParser();
        String test = "https://edt-api.univ-avignon.fr/api/exportAgenda/tdoption/def50200a0ab5088d0b6ff2fa538bcf5a4a06af864aaf41bc62a3f44269e36441dacce402ae73c688414061d37f807aafb9bdcef7ec86c0754b0131eeddf4eac47804cb9e7ab7582a2e65ec3eb1f8016c4cbe9f9b7508b52";
        EmploiDuTemps edt = parser.parseEDT(test);
        for(Evenement event: edt.getEvents()){
            eventList.getChildren().add(getNewEvent(event.getDescription()));
        }
        System.out.println(edt);
    }

    protected HBox getNewEvent(String description) {
        HBox box = new HBox();
        box.getStyleClass().add("eventbox");
        box.getChildren().clear();
        box.getChildren().add(new Label(description));
        return box;
    }
}