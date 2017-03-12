package com.example.zlink.myappmvp.profile.tab2.di;

import com.example.zlink.myappmvp.profile.tab2.AddressContract;
import com.example.zlink.myappmvp.profile.tab2.AddressPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zlink on 10/3/2560.
 */
@Module
public class AddressModule {
    @Provides
    AddressContract.Presenter providesaddresscontract(AddressPresenter presenter){
        return presenter;
    }
}
