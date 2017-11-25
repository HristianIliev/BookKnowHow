package com.example.hristian.knowhowcom.users;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.IUsersPresenter;
import com.example.hristian.knowhowcom.Contracts.IUsersView;
import com.example.hristian.knowhowcom.R;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsersFragment extends Fragment implements IUsersView{


    private IUsersPresenter presenter;

    @Inject
    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_users, container, false);

        return root;
    }

    @Override
    public void setPresenter(IUsersPresenter presenter) {
        this.presenter = presenter;
    }
}
