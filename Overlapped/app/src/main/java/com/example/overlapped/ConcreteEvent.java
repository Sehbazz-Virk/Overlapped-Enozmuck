package com.example.overlapped;

import java.time.LocalDateTime;

public abstract class ConcreteEvent extends Event {


    @Override
    public String getType() {
        return "ConcreteEvent";
    }
}