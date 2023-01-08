package com.example.overlapped;

import android.widget.CalendarView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainEventFragment extends Fragment {
    FloatingActionButton addEvent;
    CalendarView calendarToAdd;
    RecyclerView eventRecyclerView;


    public MainEventFragment() {
        super(R.layout.home_fragment);
    }

}
