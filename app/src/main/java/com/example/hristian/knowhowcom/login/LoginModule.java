package com.example.hristian.knowhowcom.login;

import com.example.hristian.knowhowcom.AuthenticationProvider;
import com.example.hristian.knowhowcom.Contracts.ILoginPresenter;
import com.example.hristian.knowhowcom.Contracts.ILoginView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides @Named("loginFragment")
    ILoginView provideLoginFragment(){
        return new LoginFragment();
    }

    @Provides @Named("loginPresenter")
    ILoginPresenter provideLoginPresenter(@Named("loginFragment") ILoginView view, AuthenticationProvider authenticationProvider){
        return new LoginPresenter(view, authenticationProvider);
    }
}
