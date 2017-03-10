package com.example.zlink.myappmvp.profile;

import com.example.zlink.myappmvp.Base.BasePresenter;
import com.example.zlink.myappmvp.detail.model.DataUser;

/**
 * Created by Zlink on 10/3/2560.
 */

public interface ProfileContract {
    interface View{
        void ShowDataUser(DataUser dataUser);
    }

    interface Presenter extends BasePresenter<ProfileContract.View>{
        void Preparedata(DataUser dataUser);
    }
}
