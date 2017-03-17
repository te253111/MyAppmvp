package com.example.data.repository.datastore.interfacedata;

import com.example.domain.LoginUsecase;

import io.reactivex.Observable;

/**
 * Created by Zlink on 8/3/2560.
 */

public interface Logindatastore {
    public Observable<LoginUsecase.ResponsValue> chklogin(LoginUsecase.RequestValue requestValue);
}
