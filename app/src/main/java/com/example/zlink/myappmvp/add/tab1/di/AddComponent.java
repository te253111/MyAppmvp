package com.example.zlink.myappmvp.add.tab1.di;

import com.example.zlink.myappmvp.add.tab1.AddFragment;
import com.example.zlink.myappmvp.di.ActivityScope;
import com.example.zlink.myappmvp.di.AppComponent;

import dagger.Component;

/**
 * Created by Zlink on 14/3/2560.
 */
@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {AddModule.class})
public interface AddComponent{
    void inject(AddFragment addFragment);
}