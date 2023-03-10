package com.example.overlapped;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Event implements Serializable {
    String id;
    User owner;
    ArrayList<User> users;

    // Base constructor
    public Event(){}

    // Constructor for creating a new Event that does not already exist
    public Event(User owner, ArrayList<User> users){
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

    public List<String> getUsersEmails() {
        List<String> list = new ArrayList<>();
        for (User u: getUsers()){
            list.add(u.getEmail());
        }
        return list;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public abstract String getType();
}