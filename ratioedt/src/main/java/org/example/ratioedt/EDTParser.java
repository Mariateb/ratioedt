package org.example.ratioedt;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class EDTParser {

    String[] keywords = {"BEGIN", "CATEGORIES", "DTSTAMP", "DTEND", "SUMMARY;LANGUAGE=fr", "DESCRIPTION;LANGUAGE=fr", "X-ALT-DESC;FMTTYPE=text/html", "END", "LOCATION", "LAST-MODIFIED", "DTSTART", "UID"};

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

    private String[] separateKeyword(String source) {
        for(String key: keywords) {
            if(source.startsWith(key)) {
                return new String[]{key, source.substring(key.length() + 1)};
            }
        }
        return new String[]{"N/A", source};
    }

    public EmploiDuTemps parseEDT(String source) throws IOException {
        String content = this.getFileFromURL(source);

        EmploiDuTemps edt = new EmploiDuTemps();

        String[] lines = content.split(System.lineSeparator());
        boolean parsingDescription = false;
        String description = "";
        Evenement event = null;

        for(String line : lines){
            String[] lineInput = this.separateKeyword(line);
            if(Objects.equals(line, "BEGIN:VEVENT")) {
                event = new Evenement();
                continue;
            }
            if(Objects.equals(line, "END:VEVENT")) {
                edt.addEvent(event);
                parsingDescription = false;
                continue;
            }

            if(Objects.equals(lineInput[0], "UID")) {
                event.setUID(lineInput[1]);
                continue;
            }
            if(Objects.equals(lineInput[0], "DTSTART")) {
                event.setDTStart(lineInput[1]);
                continue;
            }
            if(Objects.equals(lineInput[0], "DTEND")) {
                event.setDTEnd(lineInput[1]);
                continue;
            }

            if(Objects.equals(lineInput[0], "DESCRIPTION;LANGUAGE=fr")) {
                description = lineInput[1];
                parsingDescription = true;
                continue;
            }

            if(Objects.equals(lineInput[0], "N/A") && parsingDescription) {
                description += lineInput[1];
                continue;
            }

            if(!Objects.equals(lineInput[0], "N/A") && parsingDescription) {
                event.setDescription(description);
                parsingDescription = false;
                continue;
            }
        }
        return edt;
    }

}
