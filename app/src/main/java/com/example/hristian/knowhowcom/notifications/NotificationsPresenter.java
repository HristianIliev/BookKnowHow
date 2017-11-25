package com.example.hristian.knowhowcom.notifications;

import com.example.hristian.knowhowcom.Contracts.INotificationsPresenter;
import com.example.hristian.knowhowcom.Contracts.INotificationsView;

import javax.inject.Named;

/**
 * Created by Hristian on 11/23/2017.
 */

public class NotificationsPresenter implements INotificationsPresenter {

    private final INotificationsView view;

    public NotificationsPresenter(@Named("notificationsView")INotificationsView view){
        this.view = view;

        this.getView().setPresenter(this);
    }

    @Override
    public INotificationsView getView() {
        return this.view;
    }
}
