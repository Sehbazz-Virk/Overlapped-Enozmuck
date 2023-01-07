package com.example.overlapped;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        //Insert the logic for navigation here if we have multiple activities:
        switchToEventActivity();
    }

    private void switchToEventActivity() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}
