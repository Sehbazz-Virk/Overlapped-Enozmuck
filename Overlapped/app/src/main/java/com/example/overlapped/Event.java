package com.example.overlapped;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Event {
    String id;
    User owner;
    ArrayList<User> users;
    LocalDateTime times;

    Database db = new Database().getInstance();

    // Base constructor
    public Event(){}

    // Constructor for creating a new Event that does not already exist
    public Event(User owner, ArrayList<User> users, LocalDateTime times){
        this.owner = owner;
        this.users = users;
        this.times = times;
    }

    // Constructor for associating this Event object to an event that is in the database
    public Event(String id){
        this.id = id;

        // fetch info from db

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public LocalDateTime getTimes() {
        return times;
    }

    public void setTimes(LocalDateTime times) {
        this.times = times;
    }
}