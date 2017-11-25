package com.example.hristian.knowhowcom.dashboard;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.IDashboardPresenter;
import com.example.hristian.knowhowcom.Contracts.IDashboardView;
import com.example.hristian.knowhowcom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements IDashboardView {


    private IDashboardPresenter presenter;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        return root;
    }

    @Override
    public void setPresenter(IDashboardPresenter presenter) {
        this.presenter = presenter;
    }
}
