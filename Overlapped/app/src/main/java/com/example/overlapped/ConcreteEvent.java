package com.example.overlapped;

import java.time.LocalDateTime;
import java.util.List;

public class ConcreteEvent extends Event {

    LocalDateTime startTime;
    LocalDateTime endTime;

    public ConcreteEvent(LocalDateTime startTime, LocalDateTime endTime, User owner, List<User> users) {
        super(owner, users);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}