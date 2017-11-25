package com.example.hristian.knowhowcom.users;

import com.example.hristian.knowhowcom.Contracts.IUsersPresenter;
import com.example.hristian.knowhowcom.Contracts.IUsersView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Hristian on 11/25/2017.
 */

public class UsersPresenter implements IUsersPresenter{

    private IUsersView view;

    @Inject
    public UsersPresenter(@Named("usersView")IUsersView view){
        this.view = view;

        this.getView().setPresenter(this);
    }

    @Override
    public IUsersView getView() {
        return this.view;
    }
}
