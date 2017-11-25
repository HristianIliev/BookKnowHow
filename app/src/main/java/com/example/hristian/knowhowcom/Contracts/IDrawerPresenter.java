package com.example.hristian.knowhowcom.Contracts;

import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;

public interface IDrawerPresenter {
    IDrawerView getView();

    void start();

    void selectDrawerItem(int position);
}
