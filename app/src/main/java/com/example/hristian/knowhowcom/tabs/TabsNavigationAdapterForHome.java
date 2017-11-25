package com.example.hristian.knowhowcom.tabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hristian.knowhowcom.Contracts.IDashboardPresenter;
import com.example.hristian.knowhowcom.Contracts.INotificationsPresenter;

/**
 * Created by Hristian on 11/24/2017.
 */

public class TabsNavigationAdapterForHome extends FragmentStatePagerAdapter {
    private final INotificationsPresenter notificationsPresenter;
    public IDashboardPresenter dashboardPresenter;

    public TabsNavigationAdapterForHome(FragmentManager fragmentManager, IDashboardPresenter dashboardPresenter, INotificationsPresenter notificationsPresenter){
        super(fragmentManager);

        this.dashboardPresenter = dashboardPresenter;
        this.notificationsPresenter = notificationsPresenter;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return (Fragment) this.dashboardPresenter.getView();
            case 1:
                return (Fragment) this.notificationsPresenter.getView();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence pageTitle = "";

        switch(position){
            case 0:
                pageTitle = "Dashboard";
                break;
            case 1:
                pageTitle = "Notifications";
                break;
        }
        return pageTitle;
    }
}
