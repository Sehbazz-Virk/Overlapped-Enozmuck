package com.example.overlapped;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

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

    public void initializeViews() {
        this.confirm = (Button) this.myView.findViewById(R.id.button_confirm);
        this.register = (Button) this.myView.findViewById(R.id.button_alternative);
        this.emailEntry = (EditText) this.myView.findViewById(R.id.email_entry);
        this.passwordEntry = (EditText) this.myView.findViewById(R.id.password_entry);

        
    }

}
