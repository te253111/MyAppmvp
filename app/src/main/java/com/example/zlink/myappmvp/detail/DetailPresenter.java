package com.example.zlink.myappmvp.detail;

import com.example.zlink.myappmvp.detail.model.DataUser;

import javax.inject.Inject;

/**
 * Created by Zlink on 9/3/2560.
 */

public class DetailPresenter implements DetailContract.Presenter {




    private DetailContract.View view;

    @Inject
    public DetailPresenter(){

    }

    @Override
    public void setView(DetailContract.View view) {
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
    public void OnDetailButtonclick() {
        DataUser dataUser = new DataUser();
        dataUser.setId("001");
        dataUser.setName("kanok");
        dataUser.setAge("28");
        view.Showresult(dataUser);
    }

    @Override
    public void GoBack() {
        view.GoBack();
    }
}
