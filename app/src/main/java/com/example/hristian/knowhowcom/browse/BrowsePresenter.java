package com.example.hristian.knowhowcom.browse;

import com.example.hristian.knowhowcom.Contracts.IBrowsePresenter;
import com.example.hristian.knowhowcom.Contracts.IBrowseView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Hristian on 11/24/2017.
 */

public class BrowsePresenter implements IBrowsePresenter{
    private final IBrowseView view;

    @Inject
    public BrowsePresenter(@Named("browseView") IBrowseView view){
        this.view = view;

        this.getView().setPresenter(this);
    }

    @Override
    public IBrowseView getView() {
        return this.view;
    }
}
