package com.example.hristian.knowhowcom.add;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.IAddPresenter;
import com.example.hristian.knowhowcom.Contracts.IAddView;
import com.example.hristian.knowhowcom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment implements IAddView{


    private IAddPresenter presenter;

    public AddFragment() {
        // Required empty publfdfsfsic constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        return root;
    }

    @Override
    public void setPresenter(IAddPresenter presenter) {
        this.presenter = presenter;
    }
}
