package com.example.zlink.myappmvp.di;

import com.example.data.LoginReposiritory;
import com.example.domain.excutor.PostExecutionThread;
import com.example.domain.resoitory.Logindomaindatastore;
import com.example.zlink.myappmvp.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zlink on 7/3/2560.
 */
@Module
public class AppModule {
    @Singleton
    @Provides
    public PostExecutionThread ProvidepostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Singleton
    @Provides
    public Logindomaindatastore logindomaindatastore(LoginReposiritory loginReposiritory){
        return loginReposiritory;
    }
}
