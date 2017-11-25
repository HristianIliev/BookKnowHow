package com.example.hristian.knowhowcom.drawer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hristian.knowhowcom.Contracts.IDrawerPresenter;
import com.example.hristian.knowhowcom.Contracts.IDrawerView;
import com.example.hristian.knowhowcom.R;
import com.example.hristian.knowhowcom.TestActivity;
import com.example.hristian.knowhowcom.home.HomeActivity;
import com.example.hristian.knowhowcom.ui.DrawerNavigator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.List;

public class DrawerNavigationFragment
        extends Fragment
        implements IDrawerView,
        Drawer.OnDrawerItemClickListener,
        AccountHeader.OnAccountHeaderListener {

    private DrawerNavigator drawerNavigator;
    private IDrawerPresenter presenter;
    private Toolbar toolbar;
    private Drawer drawer;

    public DrawerNavigationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_drawer_navigation, container, false);
        this.toolbar = root.findViewById(R.id.drawer_toolbar);

        this.presenter.start();

        return root;
    }

    @Override
    public void setPresenter(IDrawerPresenter presenter) {
        this.presenter = presenter;
    }

    public void setDrawerNavigator(DrawerNavigator drawerNavigator){
        this.drawerNavigator = drawerNavigator;
    }

    public void showDrawerWithouthAccountHeader(List<IDrawerItem> drawerItems){
        this.drawerNavigator.getDrawerBuilderWithouthAccountHeader(this.getActivity(), this.toolbar, drawerItems, this).build();
    }

    @Override
    public void showDrawerWithAccountHeader(ProfileDrawerItem profileDrawerItem, List<IDrawerItem> drawerItems) {
        this.drawer = this.drawerNavigator.getDrawerBuilderWithAccountHeader(this.getActivity(),
                profileDrawerItem,
                this,
                this.toolbar,
                drawerItems,
                this).build();
    }

    @Override
    public void changeActivityWithExtra(long identifier, String stringExtra) {
        switch((int)identifier){
            case 1:
                Intent intent1 = new Intent(this.getContext(), HomeActivity.class);
                this.startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(this.getContext(), TestActivity.class);
                intent2.putExtra("Extra", stringExtra);
                this.getActivity().startActivity(intent2);
                break;
        }
    }

    @Override
    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
        this.presenter.selectDrawerItem(position);
        return true;
    }

    @Override
    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
        return false;
    }
}
