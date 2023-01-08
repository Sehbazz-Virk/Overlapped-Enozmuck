package com.example.overlapped;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.checkerframework.checker.units.qual.C;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class LoginActivity extends AppCompatActivity {

    private Database db;

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Database db = new Database();
        User user = new User();
        user.setEmail("balls@cock.com");
        ArrayList list = new ArrayList<>();
        list.add(user);
        ConcreteEvent conk = new ConcreteEvent(LocalDateTime.of(2023,1,12,5,30),
                LocalDateTime.of(2023,1,12,7,30),user,list);
        db.addConcreteEvent(conk);
        //db.getEventTest();

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