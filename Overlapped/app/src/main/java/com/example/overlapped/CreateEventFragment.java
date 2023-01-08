package com.example.overlapped;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class CreateEventFragment extends Fragment {

    EditText eventTitleEntry;
    Button selectFromTime, selectEndTime, createEvent, cancelButton;
    TextView fromTimeText, toTimeText;
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
        // add calendar Karan
//        selectDateRange = myView.findViewById(R.id.date_range_button);
        selectFromTime = myView.findViewById(R.id.select_from_time);
        selectEndTime = myView.findViewById(R.id.select_end_time);
        createEvent = myView.findViewById(R.id.create_event);
        cancelButton = myView.findViewById(R.id.cancel_creation_event);

        fromTimeText = myView.findViewById(R.id.from_date_text);
        toTimeText = myView.findViewById(R.id.to_date_text);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventActivity.getInstance().launchHomeFragment();
            }
        });

        selectFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                TimePickerDialog picker = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                fromTimeText.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });

        selectEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);
                // time picker dialog
                TimePickerDialog picker = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                toTimeText.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });

        // add event to database

    }


}
