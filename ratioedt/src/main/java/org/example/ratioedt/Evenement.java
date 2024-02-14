package org.example.ratioedt;

public class Evenement {
    private String UID;
    private String DTStart;
    private String DTEnd;
    private String description;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getDTStart() {
        return DTStart;
    }

    public void setDTStart(String DTStart) {
        this.DTStart = DTStart;
    }

    public String getDTEnd() {
        return DTEnd;
    }

    public void setDTEnd(String DTEnd) {
        this.DTEnd = DTEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        String toReturn = "";

        toReturn += "UID : " +  UID + System.lineSeparator();
        toReturn += "DTSTART : " +  DTStart + System.lineSeparator();
        toReturn += "DTEND : " +  DTEnd + System.lineSeparator();
        toReturn += "DESCRIPTION : " +  description + System.lineSeparator();

        return toReturn;
    }
}
