package com.example.zlink.myappmvp.detail;

import com.example.zlink.myappmvp.Base.BasePresenter;
import com.example.zlink.myappmvp.detail.model.DataUser;
import com.example.zlink.myappmvp.login.LoginContract;

/**
 * Created by Zlink on 9/3/2560.
 */

public interface DetailContract {
    interface View{
        void Showresult(DataUser dataUser);
        void GoBack();
    }
    interface Presenter extends BasePresenter<DetailContract.View> {
        void OnDetailButtonclick();
        void GoBack();
    }
}
