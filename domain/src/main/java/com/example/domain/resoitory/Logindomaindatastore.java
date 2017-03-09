package com.example.domain.resoitory;

import com.example.domain.LoginUsecase;

import io.reactivex.Observable;

/**
 * Created by Zlink on 8/3/2560.
 */

public interface Logindomaindatastore {
    public Observable<LoginUsecase.ResponsValue> chklogin(LoginUsecase.RequestValue requestValue);
}
