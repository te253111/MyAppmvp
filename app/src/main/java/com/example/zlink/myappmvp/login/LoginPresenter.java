package com.example.zlink.myappmvp.login;

import android.os.Debug;
import android.util.Log;

import com.example.domain.LoginUsecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Zlink on 7/3/2560.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    @Inject
    public LoginPresenter(){

    }

    @Inject
    LoginUsecase usecase;

    @Override
    public void OnloginButtonclick(String user, String pass) {
        LoginUsecase.RequestValue requestValue = new LoginUsecase.RequestValue();
        requestValue.setUser(user);
        requestValue.setPass(pass);
        usecase.execute(requestValue,new LoginUsecaseObserver());
    }

    // DisposableObserver Can be cancel Process
    class LoginUsecaseObserver extends DisposableObserver<LoginUsecase.ResponsValue>{
        @Override
        public void onNext(LoginUsecase.ResponsValue value) {
            if(value.getTxtmessage().equals("true")){
                view.GotoPageDetail();
            }else {
                view.Showresultstatus("Status : Loin false");
            }
        }

        @Override
        public void onError(Throwable e) {
            view.Showresultstatus(e.getMessage());
        }

        @Override
        public void onComplete() {

        }


    }


    @Override
    public void setView(LoginContract.View view) {
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
}
