package com.example.zlink.myappmvp.login;

import com.example.zlink.myappmvp.Base.BasePresenter;

/**
 * Created by Zlink on 7/3/2560.
 */

public interface LoginContract {
    interface View{
        void Showresultstatus(String result);
        void GotoPageDetail();
    }
    interface Presenter extends BasePresenter<LoginContract.View>{
        void OnloginButtonclick(String user,String pass);
    }
}
