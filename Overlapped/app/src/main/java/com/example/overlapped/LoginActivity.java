package com.example.overlapped;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.UUID;

public class LoginActivity extends AppCompatActivity {

    private Database db;

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    private FragmentManager fragmentManager = getSupportFragmentManager();

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
        this.fragmentManager.beginTransaction()
                .replace(R.id.login_fragment_container, LoginFragment.class, null, "LoginFrag")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();

    }

    public void showRegisterFragment() {

        // launch register fragment
        this.fragmentManager.beginTransaction()
                .replace(R.id.login_fragment_container, RegisterFragment.class, null, "RegisterFrag")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

    public void launchApp() {

        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);

    }

}