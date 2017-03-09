package com.example.zlink.myappmvp.detail.di;

import com.example.zlink.myappmvp.detail.DetailContract;
import com.example.zlink.myappmvp.detail.DetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zlink on 9/3/2560.
 */
@Module
public class DetailModule {
    @Provides
    public DetailContract.Presenter providesdetailcontract(DetailPresenter presenter){
        return presenter;
    }
}
