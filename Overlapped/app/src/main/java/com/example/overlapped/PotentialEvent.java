package com.example.overlapped;

import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Set;

public class PotentialEvent extends Event {

    private LocalDateTime earliestTime;
    private LocalDateTime latestTime;
    private int duration;

    // months -> days -> half hours -> List[] tuples
    // HashMap<int, HashMap> months
    HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<Pair<String, Integer>>>>> availabilities;

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

    public List<Pair<String, Integer>> getAvailabilities(int month, int day, int halfHour) {

        return availabilities.get(month).get(day).get(halfHour);

    }

    public void addAvailability(User user, int month, int day, int halfHour, int val) {

        Pair<String, Integer> userAvail = new Pair(user.getEmail(), val);

        if (!availabilities.containsKey(month)) {
            availabilities.put(month, new HashMap<>());
        }

        if (!availabilities.get(month).containsKey(day)) {
            availabilities.get(month).put(day, new HashMap<>());
        }

        if (!availabilities.get(month).get(day).containsKey(halfHour)) {
            availabilities.get(month).get(day).put(halfHour, new ArrayList<>());
        }

        availabilities.get(month).get(day).get(halfHour).add(userAvail);


    }

}