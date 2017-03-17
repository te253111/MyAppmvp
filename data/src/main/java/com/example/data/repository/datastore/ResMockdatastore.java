package com.example.data.repository.datastore;

import com.example.data.repository.datastore.interfacedata.ResDatastore;
import com.example.domain.ResUsecase;
import com.example.domain.entity.HobbyEntity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Zlink on 16/3/2560.
 */

public class ResMockdatastore implements ResDatastore {


    @Override
    public Observable<ResUsecase.ResponsValue> getresult(ResUsecase.RequestValue requestValue) {
        return Observable.create(new ObservableOnSubscribe<ResUsecase.ResponsValue>() {
            @Override
            public void subscribe(ObservableEmitter<ResUsecase.ResponsValue> e) throws Exception {
                ResUsecase.ResponsValue value = new ResUsecase.ResponsValue();
                value.setHobbyEntity(HobbyEntity.getInstance());
                e.onNext(value);
                e.onComplete();
            }
        });
    }
}
