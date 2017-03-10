package com.example.zlink.myappmvp.profile.di;

import com.example.zlink.myappmvp.di.ActivityScope;
import com.example.zlink.myappmvp.di.AppComponent;
import com.example.zlink.myappmvp.login.di.LoginModule;
import com.example.zlink.myappmvp.profile.ProfileContract;
import com.example.zlink.myappmvp.profile.ProfileFragment;

import dagger.Component;

/**
 * Created by Zlink on 10/3/2560.
 */
@ActivityScope
@Component(modules = ProfileModule.class ,dependencies = {AppComponent.class})
public interface Profilecomponent {
    void inject(ProfileFragment fragment);
}
