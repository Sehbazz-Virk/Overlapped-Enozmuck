package com.example.overlapped;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {
    Button confirm;
    Button cancel;
    EditText emailEntry;
    EditText passwordEntry;
    View myView;

    public RegisterFragment() {
        super(R.layout.register_fragment);
    }

    @Override
    @Nullable
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        this.myView = view;

        initializeViews();
    }

    public void initializeViews() {
        this.confirm = (Button) this.myView.findViewById(R.id.button_confirm_register);
        this.cancel = (Button) this.myView.findViewById(R.id.button_cancel_register);
        this.emailEntry = (EditText) this.myView.findViewById(R.id.register_email_entry);
        this.passwordEntry = (EditText) this.myView.findViewById(R.id.register_password_entry);
    }

}
