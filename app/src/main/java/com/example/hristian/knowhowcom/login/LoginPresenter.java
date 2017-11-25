package com.example.hristian.knowhowcom.login;

import android.view.View;
import android.widget.EditText;

import com.example.hristian.knowhowcom.AuthenticationProvider;
import com.example.hristian.knowhowcom.Contracts.ILoginPresenter;
import com.example.hristian.knowhowcom.Contracts.ILoginView;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hristian on 11/19/2017.
 */

public class LoginPresenter implements ILoginPresenter{

    private final ILoginView view;
    private final AuthenticationProvider authenticationProvider;

    @Inject
    public LoginPresenter(@Named("loginFragment") ILoginView view, AuthenticationProvider authenticationProvider){
        this.view = view;

        this.getView().setLoginPresenter(this);

        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public ILoginView getView() {
        return this.view;
    }

    @Override
    public void start() {

    }

    @Override
    public void attemptLogin(EditText emailEditText, EditText passwordEditText) {
        emailEditText.setError(null);
        passwordEditText.setError(null);

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!this.authenticationProvider.isEmailValid(email)) {
            emailEditText.setError("Invalid email");
            focusView = emailEditText;
            cancel = true;
        }

        if(!this.authenticationProvider.isPasswordValid(password)){
            passwordEditText.setError("Invalid password");
            focusView = passwordEditText;
            cancel = true;
        }

        if(cancel){
            focusView.requestFocus();
        }
        else{
            this.getView().showProgress(true);
            String url = "";
            this.authenticationProvider.authenticate(email, password, url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            .subscribe(result -> {
                if(result){
                    this.getView().navigiteToHomeActivity();
                }else{

                }
            });
        }
    }


}
