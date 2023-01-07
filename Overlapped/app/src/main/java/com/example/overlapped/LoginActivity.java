package com.example.overlapped;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity {

    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = Database.getInstance();
        db.addEventTest(UUID.randomUUID());

    }
}