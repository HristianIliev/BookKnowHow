package com.example.hristian.knowhowcom.Contracts;

import android.widget.EditText;

/**
 * Created by Hristian on 11/19/2017.
 */

public interface ILoginPresenter {
    ILoginView getView();

    void start();

    void attemptLogin(EditText emailEditText, EditText passwordEditText);
}
