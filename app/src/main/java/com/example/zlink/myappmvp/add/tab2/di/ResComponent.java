package com.example.zlink.myappmvp.add.tab2.di;

import com.example.zlink.myappmvp.add.tab2.ResFragment;
import com.example.zlink.myappmvp.di.ActivityScope;
import com.example.zlink.myappmvp.di.AppComponent;

import dagger.Component;

/**
 * Created by Zlink on 14/3/2560.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ResModule.class})
public interface ResComponent {
    void inject(ResFragment resFragment);
}