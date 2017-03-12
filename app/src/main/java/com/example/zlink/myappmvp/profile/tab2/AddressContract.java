package com.example.zlink.myappmvp.profile.tab2;

import com.example.zlink.myappmvp.Base.BasePresenter;
import com.example.zlink.myappmvp.detail.model.DataUser;

/**
 * Created by Zlink on 10/3/2560.
 */

public interface AddressContract {
    interface View{
        void ShowDataUser(DataUser dataUser);
    }

    interface Presenter extends BasePresenter<AddressContract.View>{
        void Preparedata(DataUser dataUser);
    }
}
