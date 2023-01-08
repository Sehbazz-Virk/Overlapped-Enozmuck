package com.example.overlapped;

import java.time.LocalDateTime;
import java.util.Map;

public abstract class PotentialEvent extends Event {

    private LocalDateTime earliestTime;
    private LocalDateTime latestTime;

    //Map<int, Map> time = new Map<int, Map>;

    public void setAvailability(User user, LocalDateTime start, LocalDateTime end){

    }

    @Override
    public String getType() {
        return "PotentialEvent";
    }

}