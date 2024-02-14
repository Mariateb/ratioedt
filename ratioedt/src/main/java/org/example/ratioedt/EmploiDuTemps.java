package org.example.ratioedt;

import java.lang.reflect.Array;
import java.util.*;

public class EmploiDuTemps {
    private ArrayList<Evenement> events = new ArrayList<Evenement>();

    public void addEvent(Evenement event) {
        this.events.add(event);
    }

    public ArrayList<Evenement> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        for(Evenement event: events) {
            toReturn.append("===============").append(System.lineSeparator());
            toReturn.append(event.toString());
        }
        return toReturn.toString();
    }
}
