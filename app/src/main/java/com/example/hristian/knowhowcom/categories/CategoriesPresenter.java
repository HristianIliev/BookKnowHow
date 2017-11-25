package com.example.hristian.knowhowcom.categories;

import com.example.hristian.knowhowcom.Contracts.ICategoriesPresenter;
import com.example.hristian.knowhowcom.Contracts.ICategoriesView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Hristian on 11/25/2017.
 */

public class CategoriesPresenter implements ICategoriesPresenter {
    private ICategoriesView view;

    @Inject
    public CategoriesPresenter(@Named("categoriesView")ICategoriesView view){
        this.view = view;

        this.getView().setPresenter(this);
    }

    @Override
    public ICategoriesView getView() {
        return this.view;
    }
}
