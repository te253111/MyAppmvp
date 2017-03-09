package com.example.zlink.myappmvp.detail.di;

import com.example.zlink.myappmvp.detail.DetailFragment;
import com.example.zlink.myappmvp.di.ActivityScope;
import com.example.zlink.myappmvp.di.AppComponent;
import com.example.zlink.myappmvp.login.di.LoginModule;

import dagger.Component;

/**
 * Created by Zlink on 9/3/2560.
 */
@ActivityScope
@Component(modules = DetailModule.class ,dependencies = {AppComponent.class})
public interface Detailcomponent {
    void inject(DetailFragment fragment);
}
