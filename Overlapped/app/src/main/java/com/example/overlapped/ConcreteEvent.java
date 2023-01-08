package com.example.overlapped;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConcreteEvent extends Event {

    public ConcreteEvent(User owner, ArrayList<User> users, LocalDateTime times){
        super(owner, users, times);
    }
}