package com.example.hristian.knowhowcom.notifications;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.INotificationsPresenter;
import com.example.hristian.knowhowcom.Contracts.INotificationsView;
import com.example.hristian.knowhowcom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsFragment extends Fragment implements INotificationsView{


    private INotificationsPresenter presenter;

    public NotificationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        return root;
    }

    @Override
    public void setPresenter(INotificationsPresenter presenter) {
        this.presenter = presenter;
    }
}
