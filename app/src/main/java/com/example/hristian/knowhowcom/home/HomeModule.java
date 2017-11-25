package com.example.hristian.knowhowcom.home;

import com.example.hristian.knowhowcom.Contracts.IAddPresenter;
import com.example.hristian.knowhowcom.Contracts.IAddView;
import com.example.hristian.knowhowcom.Contracts.IBrowsePresenter;
import com.example.hristian.knowhowcom.Contracts.IBrowseView;
import com.example.hristian.knowhowcom.Contracts.IDashboardPresenter;
import com.example.hristian.knowhowcom.Contracts.IDashboardView;
import com.example.hristian.knowhowcom.Contracts.IDrawerPresenter;
import com.example.hristian.knowhowcom.Contracts.IDrawerView;
import com.example.hristian.knowhowcom.Contracts.IHomePresenter;
import com.example.hristian.knowhowcom.Contracts.IHomeView;
import com.example.hristian.knowhowcom.Contracts.INotificationsPresenter;
import com.example.hristian.knowhowcom.Contracts.INotificationsView;
import com.example.hristian.knowhowcom.add.AddFragment;
import com.example.hristian.knowhowcom.add.AddPresenter;
import com.example.hristian.knowhowcom.browse.BrowseFragment;
import com.example.hristian.knowhowcom.browse.BrowsePresenter;
import com.example.hristian.knowhowcom.dashboard.DashbboardPresenter;
import com.example.hristian.knowhowcom.dashboard.DashboardFragment;
import com.example.hristian.knowhowcom.fragments.DrawerNavigationFragment;
import com.example.hristian.knowhowcom.notifications.NotificationsFragment;
import com.example.hristian.knowhowcom.notifications.NotificationsPresenter;
import com.example.hristian.knowhowcom.presenters.DrawerPresenter;
import com.example.hristian.knowhowcom.ui.DrawerNavigator;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides @Named("drawerPresenter")
    IDrawerPresenter provideDrawerPresenter(@Named("drawerNavigationFragment") IDrawerView view,
                                            DrawerNavigator drawerNavigator){
        return new DrawerPresenter(view, drawerNavigator);
    }

    @Provides @Named("drawerNavigationFragment")
    IDrawerView provideDrawerNavigationFragment() {
        return new DrawerNavigationFragment();
    }

    @Provides @Named("homePresenter")
    IHomePresenter provideHomePresenter(@Named("homeView")IHomeView view){
        return new HomePresenter(view);
    }

    @Provides @Named("homeView")
    IHomeView provideHomeView(){
        return new HomeFragment();
    }

    @Provides @Named("dashboardPresenter")
    IDashboardPresenter provideDashboardPresenter(@Named("dashboardView")IDashboardView view){
        return new DashbboardPresenter(view);
    }

    @Provides @Named("dashboardView")
    IDashboardView provideDashboardView(){
        return new DashboardFragment();
    }

    @Provides @Named("notificationsPresenter")
    INotificationsPresenter provideNotificationsPresneter(@Named("notificationsView")INotificationsView view){
        return new NotificationsPresenter(view);
    }

    @Provides @Named("notificationsView")
    INotificationsView provideNotificationsView(){
        return new NotificationsFragment();
    }

    @Provides @Named("browsePresenter")
    IBrowsePresenter provideBrowsePresneter(@Named("browseView")IBrowseView view){
        return new BrowsePresenter(view);
    }

    @Provides @Named("browseView")
    IBrowseView provideBrowseView(){
        return new BrowseFragment();
    }

    @Provides @Named("addPresenter")
    IAddPresenter provideAddPresneter(@Named("addView")IAddView view){
        return new AddPresenter(view);
    }

    @Provides @Named("addView")
    IAddView provideAddeView(){
        return new AddFragment();
    }
}
