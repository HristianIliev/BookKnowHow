package com.example.hristian.knowhowcom.add;

import com.example.hristian.knowhowcom.Contracts.IAddPresenter;
import com.example.hristian.knowhowcom.Contracts.IAddView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Hristian on 11/24/2017.
 */

public class AddPresenter implements IAddPresenter {
    private final IAddView view;

    @Inject
    public AddPresenter(@Named("addView") IAddView view){
        this.view = view;

        this.getView().setPresenter(this);
    }
    @Override
    public IAddView getView() {
        return this.view;
    }
}
