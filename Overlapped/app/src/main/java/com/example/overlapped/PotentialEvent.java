package com.example.overlapped;

import android.util.Pair;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
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

    public void findTime() {

     Integer bestScore = -1;
     LocalDateTime bestTime;


     // sort the 4-element array of "tuples" by the first element
     Arrays.sort(array, new Comparator<Object[]>() {
        @Override
        public int compare(Object[] o1, Object[] o2) {
            Integer i1 = (Integer) (o1[0]);
            Integer i2 = (Integer) (o2[0]);
            return i1.compareTo(i2);
        }
     });

    }

}