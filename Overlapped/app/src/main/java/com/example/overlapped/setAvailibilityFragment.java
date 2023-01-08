package com.example.overlapped;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.ColorInt;
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
import java.util.Objects;

public class setAvailibilityFragment extends Fragment implements RecyclerClickListener {

    RecyclerView availRecyclerView;
    MaterialCalendarView calendarView;
    private View myView;

    PotentialEvent event;
    User user;

    String mode = "edit";
    // TODO have logic for switch

    @Override
    @NonNull
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        this.myView = view;

        initializeViews();
    }

    public void setPotentialEvent(PotentialEvent event) {
        this.event = event;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private void initializeViews() {

        calendarView = (MaterialCalendarView) this.getView().findViewById(R.id.edit_calendarView);
        availRecyclerView = (RecyclerView) this.getView().findViewById(R.id.availability_recycler);

        List<CalendarDay> eventDays = new ArrayList<>();

        LocalDateTime time = LocalDateTime.of(2023, 1, 18, 1, 1);
        LocalDateTime time1 = LocalDateTime.of(2023, 2, 11, 1, 1);

        CalendarDay a = CalendarDay.from(time.getYear(), time.getMonthValue(), time.getDayOfMonth());
        CalendarDay b = CalendarDay.from(time1.getYear(), time1.getMonthValue(), time1.getDayOfMonth());

        eventDays.add(a);
        eventDays.add(b);

        EventDecorator eventHighlighter = new EventDecorator(Color.RED, eventDays, getContext());
        calendarView.addDecorator(eventHighlighter);

        Event MarcosDinner = new ConcreteEvent(time, time, new User(), new ArrayList<User>());
        Event SehbazzDinner = new ConcreteEvent(time1, time1, new User(), new ArrayList<User>());

        ArrayList<Event> allEvents = new ArrayList<Event>();
        allEvents.add(MarcosDinner);
        allEvents.add(SehbazzDinner);

        CustomEventRecyclerAdapter recyclerAdapter = new CustomEventRecyclerAdapter(this.getActivity(), allEvents);
        availRecyclerView.setAdapter(recyclerAdapter);
        availRecyclerView.setHasFixedSize(false);
        availRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }

    public setAvailibilityFragment() {
        super(R.layout.home_fragment);
    }



    @Override
    public void onItemClick(View view, int position) {
        if (Objects.equals(mode, "view")) {
            clickedInViewMode(view, position);
        } else {
            clickedInEditMode(view, position);
        }
    }

    boolean firstClicked = false;
    int firstClickPos = -1;
    int clickVal = 0;
    int[] clickVals = new int[event.getEndHalfHour() - event.getStartHalfHour() + 1];

    private void clickedInEditMode(View view, int position) {

        if (clickVals[position] == 1) {
            clickVals[position] = 2;
            view.setBackgroundColor(200);
            return;
        } else if (clickVals[position] == 2) {
            clickVals[position] = 0;
            view.setBackgroundColor(0);// TODO make sure this is white
            return;
        }

        if (!firstClicked) {
            firstClicked = true;
            firstClickPos = position;
            view.setBackgroundColor(100);
            clickVals[firstClickPos] = 1;
        } else {
            if (position == firstClickPos) {
                clickVals[firstClickPos] = 2;
                view.setBackgroundColor(200);
            } else {
                if (position < firstClickPos) {
                    for (int i = position; i < firstClickPos; i++) {
                        availRecyclerView.getChildAt(i).setBackgroundColor(clickVal * 100);
                        clickVals[i] = clickVal;
                        event.addAvailability(user, calendarView.getSelectedDate().getMonth(),
                                calendarView.getSelectedDate().getDay(), event.getStartHalfHour() + i ,clickVal);
                    }
                } else {
                    for (int i = firstClickPos; i < position; i++) {
                        availRecyclerView.getChildAt(i).setBackgroundColor(clickVal * 100);
                        clickVals[i] = clickVal;
                        event.addAvailability(user, calendarView.getSelectedDate().getMonth(),
                                calendarView.getSelectedDate().getDay(), event.getStartHalfHour() + i ,clickVal);
                    }
                }
                firstClicked = false;
                firstClickPos = -1;
            }
        }



    }

    private void clickedInViewMode(View view, int position) {

        new AlertDialog.Builder(getContext())
                .setTitle("Availible at this time")
                .setMessage("COMING SOON!")
                .setNegativeButton("Close", null)
                .show();

    }


}
