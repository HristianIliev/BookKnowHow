package com.example.hristian.knowhowcom.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.hristian.knowhowcom.Contracts.ILoginPresenter;
import com.example.hristian.knowhowcom.R;
import com.example.hristian.knowhowcom.SiteAppApplication;

import javax.inject.Inject;
import javax.inject.Named;

public class LoginActivity extends AppCompatActivity{
    @Inject @Named("loginPresenter")
    public ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        this.inject();

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_login_form_fragment, (Fragment) this.loginPresenter.getView())
                .commit();
    }

    private void inject() {
        ((SiteAppApplication)this.getApplication())
                .getComponent()
                .inject(this);
    }
}

