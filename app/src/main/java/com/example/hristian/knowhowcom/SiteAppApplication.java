package com.example.hristian.knowhowcom;

import android.app.Application;

import com.example.hristian.knowhowcom.home.HomeActivity;
import com.example.hristian.knowhowcom.home.HomeModule;
import com.example.hristian.knowhowcom.login.LoginActivity;
import com.example.hristian.knowhowcom.login.LoginModule;

import dagger.Component;

/**
 * Created by Hristian on 11/18/2017.
 */

public class SiteAppApplication extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        this.component = DaggerSiteAppApplication_ApplicationComponent
                .builder()
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }

    @Component(modules = {HomeModule.class, LoginModule.class})
    public interface ApplicationComponent{
        void inject(HomeActivity homeActivity);

        void inject(LoginActivity loginActivity);
    }
}
