package com.example.data.repository.datastore.interfacedata;

import com.example.domain.DetailUsecase;

import io.reactivex.Observable;

/**
 * Created by Zlink on 14/3/2560.
 */

public interface Detaildatastore {
    public Observable<DetailUsecase.ResponsValue> getDetail(DetailUsecase.RequestValue requestValue);
}
