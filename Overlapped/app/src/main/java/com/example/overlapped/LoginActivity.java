package com.example.overlapped;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Database db;

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (auth.getCurrentUser() != null) {
            launchApp();
        } else {
            showLoginFragment();
        }

    }

    public void showLoginFragment() {

        // launch login fragment

    }

    public void showRegisterFragment() {

        // launch register fragment

    }

    public void launchApp() {

        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);

    }

}