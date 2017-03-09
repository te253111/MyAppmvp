package com.example.data;

import com.example.data.repository.datastore.Logindatastore;
import com.example.data.repository.datastore.Loginmockdatastore;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Zlink on 8/3/2560.
 */
@Singleton
public class LoginReposiritory implements Logindatastore {

    @Inject
    public LoginReposiritory(){

    }

    @Override
    public Observable<LoginUsecase.ResponsValue> chklogin(LoginUsecase.RequestValue requestValue) {
        Loginmockdatastore  data = new Loginmockdatastore();
        return data.chklogin(requestValue);
    }
}
