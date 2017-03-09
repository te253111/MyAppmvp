package com.example.data;

import com.example.data.repository.datastore.LoginBooleandatastore;
import com.example.data.repository.datastore.Logindatastore;
import com.example.data.repository.datastore.Loginmockdatastore;
import com.example.domain.LoginUsecase;
import com.example.domain.resoitory.Logindomaindatastore;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Zlink on 8/3/2560.
 */
@Singleton
public class LoginReposiritory implements Logindomaindatastore {
    @Inject
    public LoginReposiritory(){

    }

    @Override
    public Observable<LoginUsecase.ResponsValue> chklogin(LoginUsecase.RequestValue requestValue) {
        Logindatastore  data = new LoginBooleandatastore();
        //Logindatastore  data = new Loginmockdatastore();
        return data.chklogin(requestValue);
    }
}
