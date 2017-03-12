package com.example.zlink.myappmvp.profile.tab2.di;

import com.example.zlink.myappmvp.di.ActivityScope;
import com.example.zlink.myappmvp.di.AppComponent;
import com.example.zlink.myappmvp.profile.tab2.AddressFragment;

import dagger.Component;

/**
 * Created by Zlink on 10/3/2560.
 */
@ActivityScope
@Component(modules = AddressModule.class ,dependencies = {AppComponent.class})
public interface Addresscomponent {
    void inject(AddressFragment fragment);
}
