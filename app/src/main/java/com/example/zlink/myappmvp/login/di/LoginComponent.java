package com.example.zlink.myappmvp.login.di;

import com.example.zlink.myappmvp.di.ActivityScope;
import com.example.zlink.myappmvp.di.AppComponent;
import com.example.zlink.myappmvp.di.AppModule;
import com.example.zlink.myappmvp.login.LoginFragment;

import dagger.Component;

/**
 * Created by Zlink on 7/3/2560.
 */
@ActivityScope
@Component(modules = LoginModule.class ,dependencies = {AppComponent.class})
public interface LoginComponent {
    void inject(LoginFragment fragment);
}
