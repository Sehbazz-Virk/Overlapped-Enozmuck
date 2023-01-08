package com.example.overlapped;

import android.util.Pair;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public abstract class PotentialEvent extends Event {

    private LocalDateTime earliestTime;
    private LocalDateTime latestTime;
    private int duration;

    // months -> days -> half hours -> List[] tuples
    // Map<int, Map> months
    Map<Integer, Map<Integer, Map<Integer, List<Pair>>>> availabilities;

    Pair avails = availabilities.get(0).get(2).get(10).get(0);

    public void setAvailability(User user, LocalDateTime start, LocalDateTime end){

    }


}