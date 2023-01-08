package com.example.overlapped;

public class User {
    int uuid;
    Event[] events;

    // Create a class constructor for the Main class
    public User() {

    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
}