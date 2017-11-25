package com.example.hristian.knowhowcom.login;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.example.hristian.knowhowcom.Contracts.ILoginPresenter;
import com.example.hristian.knowhowcom.Contracts.ILoginView;
import com.example.hristian.knowhowcom.R;
import com.example.hristian.knowhowcom.home.HomeActivity;

public class LoginFragment
        extends Fragment
        implements ILoginView, View.OnClickListener {

    private ILoginPresenter loginPresenter;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button buttonSignIn;
    private ProgressBar progressBar;
    private ScrollView loginFormView;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        this.emailEditText = root.findViewById(R.id.email);
        this.passwordEditText = root.findViewById(R.id.password);
        this.buttonSignIn = root.findViewById(R.id.email_sign_in_button);
        this.buttonSignIn.setOnClickListener(this);
        this.loginFormView = root.findViewById(R.id.login_form);
        this.progressBar = root.findViewById(R.id.login_progress);

        this.loginPresenter.start();

        return root;
    }

    @Override
    public void setLoginPresenter(ILoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void onClick(View v) {
        this.loginPresenter.attemptLogin(this.emailEditText, this.passwordEditText);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            loginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
            progressBar.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
            loginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void navigiteToHomeActivity() {
        Intent intent = new Intent(this.getContext(), HomeActivity.class);
        this.startActivity(intent);
    }
}
