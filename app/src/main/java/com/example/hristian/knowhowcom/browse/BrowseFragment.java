package com.example.hristian.knowhowcom.browse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.IBrowsePresenter;
import com.example.hristian.knowhowcom.Contracts.IBrowseView;
import com.example.hristian.knowhowcom.R;

import javax.inject.Inject;

public class BrowseFragment extends Fragment implements IBrowseView{
    private IBrowsePresenter presenter;

    @Inject
    public BrowseFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_browse, container, false);

        return root;
    }

    @Override
    public void setPresenter(IBrowsePresenter presenter) {
        this.presenter = presenter;
    }
}
