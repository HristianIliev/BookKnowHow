package com.example.hristian.knowhowcom.Contracts;

import com.example.hristian.knowhowcom.ui.DrawerNavigator;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

public interface IDrawerView {
    void setPresenter(IDrawerPresenter presenter);

    void setDrawerNavigator(DrawerNavigator drawerNavigator);

    void showDrawerWithouthAccountHeader(List<IDrawerItem> drawerItems);

    void showDrawerWithAccountHeader(ProfileDrawerItem profileDrawerItem, List<IDrawerItem> drawerItems);

    void changeActivityWithExtra(long identifier, String stringExtra);
}
