package com.example.overlapped;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class EventActivity extends AppCompatActivity {
    String currentState;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Log.i("Activity: ", "Arrived at EventActivity successfully!");
    }

    public void launchHomeFragment() {
        //TODO: fill with home event fragment code.
    }

    public void launchCreateEvent() {
        //TODO: fill with create event code.
    }

    public void launchViewEvent() {
        //TODO: fill with view event code.
    }

    public void launchAddPeopleToEvent() {
        //TODO: fill with add people event code.
    }
}
