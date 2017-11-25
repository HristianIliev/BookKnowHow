package com.example.hristian.knowhowcom.ui;

import android.app.Activity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

import javax.inject.Inject;

public class DrawerNavigator {

    @Inject
    public DrawerNavigator(){

    }

    public DrawerBuilder getDrawerBuilderWithouthAccountHeader(Activity activity,
                                                               Toolbar toolbar,
                                                               List<IDrawerItem> drawerItems,
                                                               Drawer.OnDrawerItemClickListener onDrawerItemClickListener){
        DrawerBuilder drawerBuilder = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withDrawerItems(drawerItems)
                .withOnDrawerItemClickListener(onDrawerItemClickListener);

        return drawerBuilder;
    }

    public DrawerBuilder getDrawerBuilderWithAccountHeader(Activity activity,
                                                           ProfileDrawerItem profileDrawerItem,
                                                           AccountHeader.OnAccountHeaderListener onAccountHeaderListener,
                                                           Toolbar toolbar, List<IDrawerItem> drawerItems,
                                                           Drawer.OnDrawerItemClickListener onDrawerItemClickListener){

        AccountHeader accountHeaderForDrawerBuilder = new AccountHeaderBuilder()
                .withActivity(activity)
                .addProfiles(profileDrawerItem)
                .withOnAccountHeaderListener(onAccountHeaderListener)
                .build();

        DrawerBuilder drawerBuilder = new DrawerBuilder()
                .withAccountHeader(accountHeaderForDrawerBuilder)
                .withActivity(activity)
                .withToolbar(toolbar)
                .withDrawerItems(drawerItems)
                .withOnDrawerItemClickListener(onDrawerItemClickListener);

        return drawerBuilder;
    }
}
