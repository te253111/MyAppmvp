package com.example.data.repository.datastore.interfacedata;

import com.example.domain.AddUsecase;

import io.reactivex.Observable;

/**
 * Created by Zlink on 14/3/2560.
 */

public interface Adddatastore {
    public Observable<AddUsecase.ResponsValue> adddata(AddUsecase.RequestValue requestValue);
}
