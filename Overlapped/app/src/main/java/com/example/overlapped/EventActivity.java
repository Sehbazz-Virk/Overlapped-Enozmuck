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
        setContentView(R.layout.event_activity);
        Log.i("Activity: ", "Arrived at EventActivity successfully!");
        launchHomeFragment();
    }

    public void launchHomeFragment() {
        //TODO: fill with home event fragment code.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.event_fragment_container, MainEventFragment.class, null, "MainEventFragment")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

    public void launchCreateEvent() {
        //TODO: fill with create event code.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.event_fragment_container, CreateEventFragment.class, null, "CreateEventFragment")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

    public void launchViewEvent() {
        //TODO: fill with view event code.
    }

    public void launchAddPeopleToEvent() {
        //TODO: fill with add people event code.
    }
}
