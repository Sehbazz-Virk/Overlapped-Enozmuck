package com.example.overlapped;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.auth.FirebaseAuth;

public class NavigationActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        Log.i("email", FirebaseAuth.getInstance().getCurrentUser().getEmail());
        switchToEventActivity();
    }

    private void switchToEventActivity() {
        this.fragmentManager.beginTransaction()
                .replace(R.id.event_fragment_container, MainEventFragment.class, null, "NavFrag")
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
}
