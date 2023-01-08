package com.example.overlapped;


import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    Button confirm;
    Button register;
    EditText emailEntry;
    EditText passwordEntry;
    View myView;

    public LoginFragment() {
        super(R.layout.login_fragment);
    }

    @Override
    @NonNull
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        this.myView = view;

        initializeViews();
    }

    private void initializeViews() {
        this.confirm = (Button) this.myView.findViewById(R.id.button_confirm);
        this.register = (Button) this.myView.findViewById(R.id.button_alternative);
        this.emailEntry = (EditText) this.myView.findViewById(R.id.email_entry);
        this.passwordEntry = (EditText) this.myView.findViewById(R.id.password_entry);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInEmailPassword();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity)getActivity()).showRegisterFragment();
            }
        });

    }

    /**
     * This method signs in a user. If successfully signed in, the app opens. Otherwise, the user is notified to re-attempt login
     */
    private void signInEmailPassword() {

        String email = emailEntry.getText().toString();
        String password = passwordEntry.getText().toString();

        if (email.equals("") || password.equals("")) {
            passwordEntry.setError("Invalid login");
            emailEntry.setError("Invalid login");
            return;
        }
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Log.i("AUTH", "LOGGED IN");
                passwordEntry.setError(null);
                emailEntry.setError(null);
                ((LoginActivity)getActivity()).launchApp();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("AUTH", "LOG IN FAILED");
                passwordEntry.setError("Invalid login");
                emailEntry.setError("Invalid login");

            }
        });

    }



}
