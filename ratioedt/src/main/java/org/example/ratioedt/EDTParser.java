package org.example.ratioedt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class EDTParser {

    String[] keywords = {"BEGIN", "CATEGORIES", "DTSTAMP", "DTEND", "SUMMARY;LANGUAGE=fr", "DESCRIPTION;LANGUAGE=fr", "X-ALT-DESC;FMTTYPE=text/html", "END", "LOCATION", "LAST-MODIFIED", "DTSTART"};

    private String getFileFromURL(String source) throws IOException {
        URL url = new URL(source);
        Scanner s = new Scanner(url.openStream());
        StringBuilder outputBuilder = new StringBuilder();
        while(s.hasNextLine()) {
            outputBuilder.append(s.nextLine()).append(System.lineSeparator());
        }
        String output = outputBuilder.toString();
        return output;
    }

    public EmploiDuTemps parseEDT(String source) throws IOException {
        String content = this.getFileFromURL(source);

        EmploiDuTemps edt = new EmploiDuTemps();

        String[] lines = content.split(System.lineSeparator());
        boolean parsingEvent = false;
        boolean parsingDescription = false;

        Evenement event = null;
        for(String line : lines){
            if (!Objects.equals(line, "BEGIN:VEVENT") && !parsingEvent) {
                continue;
            }
            if(Objects.equals(line, "BEGIN:VEVENT")) {
                System.out.println("AAAAA");
                parsingEvent = true;
                event = new Evenement();
                continue;
            }
            if(Objects.equals(line, "END:VEVENT")) {
                System.out.println("BBBB");
                parsingEvent = false;
                edt.addEvent(event);
                continue;
            }
            String[] lineValues = line.split(":");
            if(lineValues.length < 2) {
                continue;
            }
            System.out.println(lineValues[0] + " " + lineValues[1]);
            switch(lineValues[0]){
                case "UID":
                    event.setUID(lineValues[1]);
                case "DTSTART;VALUE=DATE":
                    event.setDTStart(lineValues[1]);
                case "DTEND;VALUE=DATE":
                    event.setDTEnd(lineValues[1]);
            }

        }
        return edt;
    }

}
