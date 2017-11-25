package com.example.hristian.knowhowcom.home;

import com.example.hristian.knowhowcom.Contracts.IHomePresenter;
import com.example.hristian.knowhowcom.Contracts.IHomeView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Hristian on 11/23/2017.
 */

public class HomePresenter implements IHomePresenter {

    private final IHomeView view;

    @Inject
    public HomePresenter(@Named("homeView")IHomeView view){
        this.view = view;

        this.getView().setPresenter(this);
    }

    @Override
    public IHomeView getView() {
        return this.view;
    }
}
