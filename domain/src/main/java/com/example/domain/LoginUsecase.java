package com.example.domain;

import com.example.domain.excutor.PostExecutionThread;
import com.example.domain.resoitory.Logindomaindatastore;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Zlink on 7/3/2560.
 */

public class LoginUsecase extends BaseUsecase<LoginUsecase.ResponsValue,LoginUsecase.RequestValue>{


    private Logindomaindatastore logindomaindatastore;

    @Inject
    public LoginUsecase(PostExecutionThread postExecutionThread,Logindomaindatastore logindomaindatastore){
        super(postExecutionThread);
        this.logindomaindatastore = logindomaindatastore;
    }

    @Override
    protected Observable<ResponsValue> Buildobservable(RequestValue requestValue) {
        return logindomaindatastore.chklogin(requestValue);
    }



    /*@Override
    protected Observable<ResponsValue> Buildobservable(final RequestValue requestValue) {
        return Observable.create(new ObservableOnSubscribe<ResponsValue>() {
            @Override
            public void subscribe(ObservableEmitter<ResponsValue> e) throws Exception {
                LoginUsecase.ResponsValue responsValue = new ResponsValue();
                if(requestValue.getPass().equals("admin") && requestValue.getPass().equals("admin")){
                    responsValue.setTxtmessage("Login OK");
                }else{
                    responsValue.setTxtmessage("Login false");
                }
                e.onNext(responsValue);
                e.onComplete();
            }
        });
    }*/

    public static class RequestValue{
        String user;
        String pass;

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

    }

    public static class ResponsValue{
        public String getTxtmessage() {
            return txtmessage;
        }

        public void setTxtmessage(String txtmessage) {
            this.txtmessage = txtmessage;
        }

        String txtmessage;
    }

}
