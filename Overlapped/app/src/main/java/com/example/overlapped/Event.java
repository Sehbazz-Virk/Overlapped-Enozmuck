package com.example.overlapped;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Event {
    String id;
    User owner;
    List<User> users;

    Database db = Database.getInstance();

    // Base constructor
    public Event(){}

    // Constructor for creating a new Event that does not already exist
    public Event(User owner, List<User> users){
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public abstract String getType();
}