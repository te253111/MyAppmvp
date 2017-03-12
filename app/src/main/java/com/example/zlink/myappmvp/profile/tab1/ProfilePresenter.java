package com.example.zlink.myappmvp.profile.tab1;

import com.example.zlink.myappmvp.detail.model.DataUser;

import javax.inject.Inject;

/**
 * Created by Zlink on 10/3/2560.
 */

public class ProfilePresenter implements ProfileContract.Presenter {


    private ProfileContract.View view;

    @Inject
    public ProfilePresenter(){

    }

    @Override
    public void setView(ProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void Preparedata(DataUser dataUser) {
            view.ShowDataUser(dataUser);
    }
}
