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

public class FragmentLogin extends Fragment {

    private TextInputLayout usernameInputLayout, passwordInputLayout;
    private TextInputEditText usernameTextInput, passwordTextInput;

    public FragmentLogin() {
    }

    public static FragmentLogin newInstance() {
        return new FragmentLogin();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.include_fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Local variables
        Button loginButton;
        TextView registerLink;

        //Get the ids
        usernameInputLayout = (TextInputLayout) view.findViewById(R.id.login_username_text_input_layout);
        usernameTextInput = (TextInputEditText) view.findViewById(R.id.login_username_text_input);
        passwordInputLayout = (TextInputLayout) view.findViewById(R.id.login_password_text_input_layout);
        passwordTextInput = (TextInputEditText) view.findViewById(R.id.login_password_text_input);
        loginButton = (Button) view.findViewById(R.id.login_button);
        registerLink = (TextView) view.findViewById(R.id.login_link_to_register);

        //Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateFields();
            }
        });

        //Register link
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFraggmentRegister();
            }
        });
    }

    private void validateFields() {

        String username = usernameTextInput.getText().toString();
        String password = passwordTextInput.getText().toString();

        //Username
        if(TextUtils.isEmpty(username)) {
            usernameInputLayout.setError(getString(R.string.text_this_field_is_required));
        }else {
            usernameInputLayout.setError(null);
        }

        //Password
        if(TextUtils.isEmpty(password)) {
            passwordInputLayout.setError(getString(R.string.text_this_field_is_required));
        }else {
            passwordInputLayout.setError(null);
        }
    }

    private void openFraggmentRegister() {
        FragmentRegister fragmentRegister = FragmentRegister.newInstance();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_body, fragmentRegister, "FragmentRegister")
                .commit();
    }
}
