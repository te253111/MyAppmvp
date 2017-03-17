package com.example.data.repository.datastore.interfacedata;

import com.example.domain.ResUsecase;

import io.reactivex.Observable;

/**
 * Created by Zlink on 16/3/2560.
 */

public interface ResDatastore {
    public Observable<ResUsecase.ResponsValue> getresult(ResUsecase.RequestValue requestValue);
}
