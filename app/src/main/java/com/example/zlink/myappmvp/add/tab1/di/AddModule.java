package com.example.zlink.myappmvp.add.tab1.di;

import com.example.zlink.myappmvp.add.tab1.AddContract;
import com.example.zlink.myappmvp.add.tab1.AddFragment;
import com.example.zlink.myappmvp.add.tab1.AddPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zlink on 14/3/2560.
 */
    @Module
    public class AddModule {
        @Provides
        AddContract.Presenter provideAddContract(AddPresenter addPresenter) {
            return addPresenter;
        }
    }


