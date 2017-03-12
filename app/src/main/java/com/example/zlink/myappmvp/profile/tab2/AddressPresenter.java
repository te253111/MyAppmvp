package com.example.zlink.myappmvp.profile.tab2;

import com.example.zlink.myappmvp.detail.model.DataUser;

import javax.inject.Inject;

/**
 * Created by Zlink on 10/3/2560.
 */

public class AddressPresenter implements AddressContract.Presenter {


    private AddressContract.View view;

    @Inject
    public AddressPresenter(){

    }

    @Override
    public void setView(AddressContract.View view) {
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
