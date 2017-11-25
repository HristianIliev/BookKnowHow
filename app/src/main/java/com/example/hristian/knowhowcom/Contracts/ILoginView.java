package com.example.hristian.knowhowcom.Contracts;

/**
 * Created by Hristian on 11/19/2017.
 */

public interface ILoginView {
    void setLoginPresenter(ILoginPresenter loginPresenter);

    void showProgress(final boolean show);

    void navigiteToHomeActivity();
}
