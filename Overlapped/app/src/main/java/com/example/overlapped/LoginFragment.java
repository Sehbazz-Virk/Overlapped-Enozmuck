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
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    EditText email_ET, password_ET;
    Button confirm_BT;
    Button signup_BT;

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    public LoginFragment() {
        super();
    }

    /**
     * This method signs in a user. If successfully signed in, the app opens. Otherwise, the user is notified to re-attempt login
     * @param email email address specified by user
     * @param password password entered by user
     */
    private void signInEmailPassword(String email, String password) {
        if (email.equals("") || password.equals("")) {
            password_ET.setError("Invalid login");
            email_ET.setError("Invalid login");
            return;
        }
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Log.i("AUTH", "LOGGED IN");
                password_ET.setError(null);
                email_ET.setError(null);
                ((LoginActivity)getActivity()).launchApp();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("AUTH", "LOG IN FAILED");
                password_ET.setError("Invalid login");
                email_ET.setError("Invalid login");

            }
        });

    }



}
