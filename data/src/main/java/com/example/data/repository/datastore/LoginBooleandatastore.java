package com.example.data.repository.datastore;

import com.example.data.repository.datastore.interfacedata.Logindatastore;
import com.example.domain.LoginUsecase;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Zlink on 8/3/2560.
 */

public class LoginBooleandatastore implements Logindatastore {
    @Override
    public Observable<LoginUsecase.ResponsValue> chklogin(final LoginUsecase.RequestValue requestValue) {
        return Observable.create(new ObservableOnSubscribe<LoginUsecase.ResponsValue>() {
            @Override
            public void subscribe(ObservableEmitter<LoginUsecase.ResponsValue> e) throws Exception {
                LoginUsecase.ResponsValue responsValue = new LoginUsecase.ResponsValue();
                if(requestValue.getPass().equals("admin") && requestValue.getPass().equals("admin")){
                    responsValue.setTxtmessage("true");
                }else{
                    responsValue.setTxtmessage("false");
                }
                e.onNext(responsValue);
                e.onComplete();
            }
        });
    }
}
