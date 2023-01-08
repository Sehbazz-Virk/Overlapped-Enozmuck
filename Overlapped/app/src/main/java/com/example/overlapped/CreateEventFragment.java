package com.example.overlapped;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class CreateEventFragment extends Fragment {

    EditText eventTitleEntry;
    Button selectDateRange, selectFromTime, selectEndTime, createEvent;
    View myView;


    public CreateEventFragment() {
        super(R.layout.add_event_fragment);
    }


    @Override
    @NonNull
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        this.myView = view;

        initializeViews();
    }

    public void initializeViews() {
        eventTitleEntry = myView.findViewById(R.id.event_title);
        selectDateRange = myView.findViewById(R.id.date_range_button);
        selectFromTime = myView.findViewById(R.id.select_from_time);
        selectEndTime = myView.findViewById(R.id.select_end_time);
        createEvent = myView.findViewById(R.id.create_event);

        selectDateRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launch alert dialog for
            }
        });

    }


}
