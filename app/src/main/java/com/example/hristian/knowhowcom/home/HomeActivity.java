package com.example.hristian.knowhowcom.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.example.hristian.knowhowcom.Contracts.IAddPresenter;
import com.example.hristian.knowhowcom.Contracts.IBrowsePresenter;
import com.example.hristian.knowhowcom.Contracts.IDashboardPresenter;
import com.example.hristian.knowhowcom.Contracts.IDrawerPresenter;
import com.example.hristian.knowhowcom.Contracts.IHomePresenter;
import com.example.hristian.knowhowcom.Contracts.INotificationsPresenter;
import com.example.hristian.knowhowcom.R;
import com.example.hristian.knowhowcom.SiteAppApplication;
import com.example.hristian.knowhowcom.tabs.TabsNavigationAdapterForHome;

import javax.inject.Inject;
import javax.inject.Named;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    @Inject
    @Named("drawerPresenter")
    public IDrawerPresenter drawerPresenter;
    @Inject
    @Named("homePresenter")
    public IHomePresenter homePresenter;
    @Inject
    @Named("dashboardPresenter")
    public IDashboardPresenter dashboardPresenter;
    @Inject
    @Named("notificationsPresenter")
    public INotificationsPresenter notificationsPresenter;
    @Inject
    @Named("browsePresenter")
    public IBrowsePresenter browsePresenter;
    @Inject
    @Named("addPresenter")
    public IAddPresenter addPresenter;

    private ViewPager pager;
    private PagerSlidingTabStrip tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_bar_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        this.inject();

        this.pager = (ViewPager) findViewById(R.id.tabs_pager);
        this.pager.setAdapter(new TabsNavigationAdapterForHome(this.getSupportFragmentManager(), this.dashboardPresenter, this.notificationsPresenter));

        this.tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        this.tabs.setViewPager(this.pager);

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_drawer, (Fragment)this.drawerPresenter.getView())
//                .replace(R.id.container_fragment_to_be_displayed, (Fragment) this.homePresenter.getView(), "Home_Fragment")
//                .addToBackStack("Home_Fragment")
                .commit();
    }

    private void inject() {
        ((SiteAppApplication)this.getApplication())
                .getComponent()
                .inject(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                //change the tabs view with the corresponding view for the fragment
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_fragment_to_be_displayed, (Fragment) this.homePresenter.getView())
                        .commit();
                break;
            case R.id.navigation_browse:
                //change the tabs view with the corresponding view for the fragment
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_fragment_to_be_displayed, (Fragment) this.browsePresenter.getView())
                        .commit();
                break;
            case R.id.navigation_add:
                //change the tabs view with the corresponding view for the fragment
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container_fragment_to_be_displayed, (Fragment) this.addPresenter.getView())
                        .commit();
                break;
        }

        return true;
    }
}
