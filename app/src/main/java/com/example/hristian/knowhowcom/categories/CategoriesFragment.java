package com.example.hristian.knowhowcom.categories;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.ICategoriesPresenter;
import com.example.hristian.knowhowcom.Contracts.ICategoriesView;
import com.example.hristian.knowhowcom.R;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment implements ICategoriesView{
    private ICategoriesPresenter presenter;

    @Inject
    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_categories, container, false);

        return root;
    }

    @Override
    public void setPresenter(ICategoriesPresenter presenter) {
        this.presenter = presenter;
    }
}
