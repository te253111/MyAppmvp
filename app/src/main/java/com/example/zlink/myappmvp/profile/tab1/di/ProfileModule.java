package com.example.zlink.myappmvp.profile.tab1.di;

import com.example.zlink.myappmvp.profile.tab1.ProfileContract;
import com.example.zlink.myappmvp.profile.tab1.ProfilePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Zlink on 10/3/2560.
 */
@Module
public class ProfileModule {
    @Provides
    ProfileContract.Presenter providesprofilecontract(ProfilePresenter presenter){
        return presenter;
    }
}
