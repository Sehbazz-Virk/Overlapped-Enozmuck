package com.example.overlapped;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment {
    Button confirm;
    Button cancel;
    EditText emailEntry;
    EditText passwordEntry;
    View myView;
    Database db;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    public RegisterFragment() {
        super(R.layout.register_fragment);
    }

    @Override
    @Nullable
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        this.myView = view;

        db = Database.getInstance();
        initializeViews();
    }

    public void initializeViews() {
        this.confirm = (Button) this.myView.findViewById(R.id.button_confirm_register);
        this.cancel = (Button) this.myView.findViewById(R.id.button_cancel_register);
        this.emailEntry = (EditText) this.myView.findViewById(R.id.register_email_entry);
        this.passwordEntry = (EditText) this.myView.findViewById(R.id.register_password_entry);

        this.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpEmailPassword();
            }
        });

        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity)getActivity()).showLoginFragment();
            }
        });
    }

    private void signUpEmailPassword() {

        String email = emailEntry.getText().toString();
        String password = passwordEntry.getText().toString();

        if (email.equals("") || password.equals("")) {
            passwordEntry.setError("Invalid signup");
            emailEntry.setError("Invalid signup");
            return;
        }
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Log.i("AUTH", "SIGN UP SUCCEEDED");
                passwordEntry.setError(null);
                emailEntry.setError(null);
                db.registerNewUser(email);
                ((LoginActivity)getActivity()).launchApp();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("AUTH", "SIGN UP FAILED");
                passwordEntry.setError("Invalid signup");
                emailEntry.setError("Invalid signup");
            }
        });
    }

}
