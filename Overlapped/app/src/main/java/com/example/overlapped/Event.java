package com.example.overlapped;

import java.time.LocalDateTime;

public abstract class Event {
    String id;
    User owner;
    User[] users;

    Database db = Database.getInstance();

    // Base constructor
    public Event(){}

    // Constructor for creating a new Event that does not already exist
    public Event(User owner, User[] users){
        this.owner = owner;
        this.users = users;
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

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public void addUser(User user) {

    }
}