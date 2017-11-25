package com.example.hristian.knowhowcom.dashboard;

import com.example.hristian.knowhowcom.Contracts.IDashboardPresenter;
import com.example.hristian.knowhowcom.Contracts.IDashboardView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Hristian on 11/23/2017.
 */

public class DashbboardPresenter implements IDashboardPresenter {

    private IDashboardView view;

    @Inject
    public DashbboardPresenter(@Named("dashboardView") IDashboardView view){
        this.view = view;

        this.getView().setPresenter(this);
    }

    @Override
    public IDashboardView getView() {
        return this.view;
    }
}
