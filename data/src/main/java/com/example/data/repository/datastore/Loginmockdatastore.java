package com.example.data.repository.datastore;

import com.example.domain.LoginUsecase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Zlink on 8/3/2560.
 */

public class Loginmockdatastore implements Logindatastore {
    @Override
    public Observable<LoginUsecase.ResponsValue> chklogin(final LoginUsecase.RequestValue requestValue) {
        return Observable.create(new ObservableOnSubscribe<LoginUsecase.ResponsValue>() {
            @Override
            public void subscribe(ObservableEmitter<LoginUsecase.ResponsValue> e) throws Exception {
                LoginUsecase.ResponsValue responsValue = new LoginUsecase.ResponsValue();
                if(requestValue.getPass().equals("admin") && requestValue.getPass().equals("admin")){
                    responsValue.setTxtmessage("Login OK");
                }else{
                    responsValue.setTxtmessage("Login false");
                }
                e.onNext(responsValue);
                e.onComplete();
            }
        });
    }
}
