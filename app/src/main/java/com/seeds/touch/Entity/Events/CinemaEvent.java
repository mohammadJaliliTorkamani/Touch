package com.seeds.touch.Entity.Events;

import android.location.Location;
import java.util.Calendar;
import java.util.HashSet;

public class CinemaEvent extends Event {
    private String filmName;

    public CinemaEvent(String title, Calendar startDate, Calendar endDate, Location location,
                       String description, HashSet<String> tags, int ATTENDER_NUMBER_RANGE, String filmName) {
        super(title, startDate, endDate, location, description, tags, ATTENDER_NUMBER_RANGE);
        this.filmName = filmName;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
}
