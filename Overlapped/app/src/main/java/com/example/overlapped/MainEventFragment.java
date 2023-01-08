package com.example.overlapped;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainEventFragment extends Fragment {
    FloatingActionButton addEvent;
    CalendarView calendarToAdd;
    RecyclerView eventRecyclerView;
    MaterialCalendarView calendarView;
    private View myView;

    @Override
    @NonNull
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        this.myView = view;

        initializeViews();
    }

    private void initializeViews() {

        calendarView = (MaterialCalendarView) this.getView().findViewById(R.id.calendarView);
        eventRecyclerView = (RecyclerView) this.getView().findViewById(R.id.event_recycler);

        List<CalendarDay> eventDays = new ArrayList<>();

        LocalDateTime time = LocalDateTime.of(2023, 1, 18, 1, 1);
        LocalDateTime time1 = LocalDateTime.of(2023, 2, 11, 1, 1);

        CalendarDay a = CalendarDay.from(time.getYear(), time.getMonthValue(), time.getDayOfMonth());
        CalendarDay b = CalendarDay.from(time1.getYear(), time1.getMonthValue(), time1.getDayOfMonth());

        eventDays.add(a);
        eventDays.add(b);

        EventDecorator eventHighlighter = new EventDecorator(Color.RED, eventDays, getContext());
        calendarView.addDecorator(eventHighlighter);

        Event MarcosDinner = new ConcreteEvent(new User(), new ArrayList<User>(), time);
        Event SehbazzDinner = new ConcreteEvent(new User(), new ArrayList<User>(), time1);


        ArrayList<Event> allEvents = new ArrayList<Event>();
        allEvents.add(MarcosDinner);
        allEvents.add(SehbazzDinner);

        CustomEventRecyclerAdapter recyclerAdapter = new CustomEventRecyclerAdapter(this.getActivity(), allEvents);
        eventRecyclerView.setAdapter(recyclerAdapter);
        eventRecyclerView.setHasFixedSize(false);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }

    public MainEventFragment() {
        super(R.layout.home_fragment);

    }

}
