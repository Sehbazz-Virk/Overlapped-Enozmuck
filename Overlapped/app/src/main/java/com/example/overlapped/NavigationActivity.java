package com.example.overlapped;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_navigation);

        //Insert the logic for navigation here if we have multiple activities:
        switchToEventActivity();
    }

    private void switchToEventActivity() {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);


    }

}
