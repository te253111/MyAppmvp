package com.example.zlink.myappmvp.di;

import com.example.domain.excutor.PostExecutionThread;
import com.example.domain.resoitory.Domainrepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Zlink on 7/3/2560.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    PostExecutionThread postExecutionThread();
    Domainrepository logindomaindatastore();
}
