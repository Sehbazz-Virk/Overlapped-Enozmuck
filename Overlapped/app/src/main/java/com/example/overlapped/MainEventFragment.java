package com.example.overlapped;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

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

        List<CalendarDay> eventDays = new ArrayList<>();

        CalendarDay a = CalendarDay.from(2023, 01, 8);
        CalendarDay b = CalendarDay.from(2023, 01, 10);
        CalendarDay c = CalendarDay.from(2023, 01, 23);

        eventDays.add(a);
        eventDays.add(b);
        eventDays.add(c);

        EventDecorator eventHighlighter = new EventDecorator(Color.RED, eventDays, getContext());
        calendarView.addDecorator(eventHighlighter);

    }

    public MainEventFragment() {
        super(R.layout.home_fragment);

    }

}
