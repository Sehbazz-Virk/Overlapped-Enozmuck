package com.example.overlapped;

import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Set;

public class PotentialEvent extends Event implements Serializable {

    //TODO: once we have the host select the window, we can populate the days below to track the range of the event duration.
    private LocalDate earliestDay;
    private LocalDate latestDay;
    private LocalDateTime earliestTime;
    private LocalDateTime latestTime;
    private int duration;

    ArrayList<Pair<Integer, Integer>> days;

    // months -> days -> half hours -> List[] tuples
    // HashMap<int, HashMap> months
    HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<Pair<String, Integer>>>>> availabilities = new HashMap<>();

    public PotentialEvent(User owner, ArrayList<User> users, LocalDateTime earliestTime, LocalDateTime latestTime, int duration, ArrayList<Pair<Integer, Integer>> days) {
        super(owner, users);
        this.earliestTime = earliestTime;
        this.latestTime = latestTime;
        this.duration = duration;
        this.days = days;

        int startHalfHour = earliestTime.getHour() * 2 + earliestTime.getMinute() / 30;
        int endHalfHour = latestTime.getHour() * 2 + latestTime.getMinute() / 30;


        for (int i = 0; i < days.size(); i++) {
            int month = days.get(i).first;
            int day = days.get(i).second;
            if (!availabilities.containsKey(month)) {
                availabilities.put(month, new HashMap<>());
            }

            if (!availabilities.get(month).containsKey(day)) {
                availabilities.get(month).put(day, new HashMap<>());
            } else {
                continue;
            }

            HashMap<Integer, ArrayList<Pair<String, Integer>>> avails = new HashMap<>();

            for (int j = startHalfHour; j <= endHalfHour; j++) {
                avails.put(j, new ArrayList<>());
            }

        }
    }

    public LocalDateTime[] findTime() {

        int months;
        int days;
        int hHours;

        LocalDateTime wStart = earliestTime;
        LocalDateTime wEnd = earliestTime.plusMinutes(30*duration);
        LocalDateTime wCurrent;
        int offset = 0;
        int score = 0;
        int tDuration = 30*duration;

        Integer[][] top4 = new Integer[4][2];

        for (int i = 0; i < 4; i++){
            top4[i][0] = 0;
            top4[i][1] = 0;
        }

        while (wEnd.plusMinutes(tDuration-1).isBefore(latestTime)){
            for (int i = 0; i < duration; i++){
                wCurrent = wStart.plusMinutes(30*i);
                months = wCurrent.getMonthValue();
                days = wCurrent.getDayOfMonth();
                hHours = wCurrent.getHour()*2 + wCurrent.getMinute() / 30;

                for (int n = 0; n < availabilities.get(months).get(days).get(hHours).size(); n++) {
                    score += (int) availabilities.get(months).get(days).get(hHours).get(n).second;
                }
            }

            top4[3][0] = score;
            top4[3][1] = offset;
            offset += 1;

            wStart = wStart.plusMinutes(30);
            wEnd = wEnd.plusMinutes(30);

            top4 = sortByFirstIndex(top4);
        }

        LocalDateTime[] result = new LocalDateTime[3];

        for (int i = 0; i < 3; i++){
            result[i] = earliestTime.plusMinutes(top4[i][1]*30);
        }
        return result;


    }

    @Override
    public String getType() {
        return "PotentialEvent";
    }

    private Integer[][] sortByFirstIndex(Integer[][] array){
        // sort the 4-element array of "tuples" by the first element
        Arrays.sort(array, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                Integer i1 = (Integer) (o1[0]);
                Integer i2 = (Integer) (o2[0]);
                return i2.compareTo(i1);
            }
        });
        return array;
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

    public LocalDate getEarliestDay() {
        return earliestDay;
    }

    public void setEarliestDay(LocalDate earliestDay) {
        this.earliestDay = earliestDay;
    }

    public LocalDate getLatestDay() {
        return latestDay;
    }

    public void setLatestDay(LocalDate latestDay) {
        this.latestDay = latestDay;
    }
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, ArrayList<Pair<String, Integer>>>>> getAvailabilities() {
        return availabilities;
    }

    public int getStartHalfHour() {

        return earliestTime.getHour() * 2 + earliestTime.getMinute() / 30;
    }

    public int getEndHalfHour() {

        return latestTime.getHour() * 2 + latestTime.getMinute() / 30;

    }
}