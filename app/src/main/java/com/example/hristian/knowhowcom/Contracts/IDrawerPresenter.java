package com.example.hristian.knowhowcom.Contracts;

public interface IDrawerPresenter {
    IDrawerView getView();

    void start();

    void selectDrawerItem(int position);
}
