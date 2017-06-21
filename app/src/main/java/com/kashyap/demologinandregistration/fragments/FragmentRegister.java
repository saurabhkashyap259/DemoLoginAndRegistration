package com.kashyap.demologinandregistration.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kashyap.demologinandregistration.R;

/**
 * Created by saurabhkashyap on 21/06/17.
 */

public class FragmentRegister extends Fragment {

    private TextInputLayout firstNameInputLayout, lastNameInputLayout, usernameInputLayout, emailInputLayout, passwordInputLayout;
    private TextInputEditText firstNameInputText, lastNameInputText, usernameInputText, emailInputText, passwordInputText;

    public FragmentRegister() {
    }

    public static FragmentRegister newInstance() {
        return new FragmentRegister();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.include_fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Local variables
        Button registerButton;
        TextView loginLink;

        //Get the ids
        firstNameInputLayout = (TextInputLayout) view.findViewById(R.id.register_first_name_input_layout);
        lastNameInputLayout = (TextInputLayout) view.findViewById(R.id.register_last_name_text_input_layout);
        usernameInputLayout = (TextInputLayout) view.findViewById(R.id.register_username_text_input_layout);
        emailInputLayout = (TextInputLayout) view.findViewById(R.id.register_email_input_layout);
        passwordInputLayout = (TextInputLayout) view.findViewById(R.id.register_password_text_input_layout);
        firstNameInputText = (TextInputEditText) view.findViewById(R.id.register_first_name_text_input);
        lastNameInputText = (TextInputEditText) view.findViewById(R.id.register_last_name_text_input);
        usernameInputText = (TextInputEditText) view.findViewById(R.id.register_username_text_input);
        emailInputText = (TextInputEditText) view.findViewById(R.id.register_email_text_input);
        passwordInputText = (TextInputEditText) view.findViewById(R.id.register_password_text_input);
        registerButton = (Button) view.findViewById(R.id.register_button);
        loginLink = (TextView) view.findViewById(R.id.register_link_to_login);

        //Register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();
            }
        });

        //Link to login
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragmentLogin();
            }
        });
    }

    private void validateFields() {
        //Get texts
        String firstName = firstNameInputText.getText().toString();
        String lastName = lastNameInputText.getText().toString();
        String username = usernameInputText.getText().toString();
        String email = emailInputText.getText().toString();
        String password = passwordInputText.getText().toString();

        //First name
        if(TextUtils.isEmpty(firstName)) {
            firstNameInputLayout.setError(getString(R.string.text_this_field_is_required));
        }else {
            firstNameInputLayout.setError(null);
        }

        //Last name
        if(TextUtils.isEmpty(lastName)) {
            lastNameInputLayout.setError(getString(R.string.text_this_field_is_required));
        }else {
            lastNameInputLayout.setError(null);
        }

        //Username
        if(TextUtils.isEmpty(username)) {
            usernameInputLayout.setError(getString(R.string.text_this_field_is_required));
        }else {
            usernameInputLayout.setError(null);
        }

        //Email
        if(TextUtils.isEmpty(email)) {
            emailInputLayout.setError(getString(R.string.text_this_field_is_required));
        }else {
            emailInputLayout.setError(null);
        }

        //Password
        if(TextUtils.isEmpty(password)) {
            passwordInputLayout.setError(getString(R.string.text_this_field_is_required));
        }else {
            passwordInputLayout.setError(null);
        }
    }

    private void openFragmentLogin() {
        FragmentLogin fragmentLogin = FragmentLogin.newInstance();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_body, fragmentLogin, "FragmentLogin")
                .commit();
    }
}
