package com.example.overlapped;

import android.app.AlertDialog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/*
    Class to handle the selection of various times for which the
    host to plan the events. Will be held modularly for ease of
    adaptation.

    NOTE: This class is to be instantiated within the constructor of the
    event class.
    //TODO: Need to implement an interface
 */
public class TimeSelect {
    ArrayList<LocalDate> datesSelected;
    AlertDialog timeDialog = null;


    public TimeSelect() {
        this.datesSelected = new ArrayList<>();
    }

    private void addEventTime(LocalDate dateSelected) {
        this.datesSelected.add(dateSelected);
    }

    //Main event call to handle the user input for date selection:
    public selectEventTime() {
        //Create dialog here:
    }

    public ArrayList<LocalDate> getEventDates() {
        return this.datesSelected;
    }
}
