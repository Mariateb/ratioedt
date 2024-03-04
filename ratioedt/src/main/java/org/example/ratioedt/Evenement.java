package org.example.ratioedt;

public class Evenement {
    private String UID;
    private int date;
    private int startHour;
    private int duration;
    private String description;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
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

        toReturn += "UID : " + UID + System.lineSeparator();
        toReturn += "Date : " + date + System.lineSeparator();
        toReturn += "Hour : " + startHour + System.lineSeparator();
        toReturn += "Duration : " + duration + System.lineSeparator();
        toReturn += "DESCRIPTION : " +  description + System.lineSeparator();

        return toReturn;
    }
}
