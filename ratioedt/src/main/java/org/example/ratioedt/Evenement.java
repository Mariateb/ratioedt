package org.example.ratioedt;

public class Evenement {
    private String categories;
    private String DTStamp;
    private String lastModified;
    private String UID;
    private String DTStart;
    private String DTEnd;
    private String summary;
    private String description;
    private String location;

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setDTStamp(String DTStamp) {
        this.DTStamp = DTStamp;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public void setDTStart(String DTStart) {
        this.DTStart = DTStart;
    }

    public void setDTEnd(String DTEnd) {
        this.DTEnd = DTEnd;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public String getDTStamp() {
        return DTStamp;
    }

    public String getLastModified() {
        return lastModified;
    }

    public String getUID() {
        return UID;
    }

    public String getDTStart() {
        return DTStart;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDTEnd() {
        return DTEnd;
    }

    public String getSummary() {
        return summary;
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
