package com.example.hristian.knowhowcom.presenters;

import android.support.v7.widget.Toolbar;

import com.example.hristian.knowhowcom.Contracts.IDrawerPresenter;
import com.example.hristian.knowhowcom.Contracts.IDrawerView;
import com.example.hristian.knowhowcom.R;
import com.example.hristian.knowhowcom.ui.DrawerNavigator;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class DrawerPresenter implements IDrawerPresenter {
    private List<IDrawerItem> drawerItems;
    private ProfileDrawerItem profileDrawerItem;
    private final IDrawerView view;
    private Drawer drawer;

    @Inject
    public DrawerPresenter(@Named("drawerNavigationFragment") IDrawerView view, DrawerNavigator drawerNavigator){
        this.view = view;

        this.getView().setPresenter(this);
        this.getView().setDrawerNavigator(drawerNavigator);
    }

    @Override
    public IDrawerView getView() {
        return this.view;
    }

    @Override
    public void start() {
        this.drawerItems = new ArrayList<>();

        this.drawerItems.add(new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_home_black_24dp));
        this.drawerItems.add(new SecondaryDrawerItem().withIdentifier(2).withName("Test"));

        this.profileDrawerItem = new ProfileDrawerItem().withName("Hristian Iliev").withEmail("hristian00i@abv.bg").withIcon(R.drawable.material_drawer_circle_mask);

        this.getView().showDrawerWithAccountHeader(this.profileDrawerItem, this.drawerItems);
    }

    @Override
    public void selectDrawerItem(int position) {
        this.getView().changeActivityWithExtra(drawerItems.get(position - 1).getIdentifier(), "Test");
    }
}
