package com.example.zlink.myappmvp.login.di;

import com.example.zlink.myappmvp.login.LoginContract;
import com.example.zlink.myappmvp.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zlink on 7/3/2560.
 */
@Module
public class LoginModule {
    @Provides
    public LoginContract.Presenter provideslogincontract(LoginPresenter presenter){
        return presenter;
    }
}
