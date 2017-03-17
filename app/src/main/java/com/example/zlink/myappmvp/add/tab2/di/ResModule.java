package com.example.zlink.myappmvp.add.tab2.di;

import com.example.zlink.myappmvp.add.tab2.ResContract;
import com.example.zlink.myappmvp.add.tab2.ResPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zlink on 14/3/2560.
 */
    @Module
    public class ResModule {
        @Provides
        ResContract.Presenter provideREsContract(ResPresenter resPresenter) {
            return resPresenter;
        }
    }


