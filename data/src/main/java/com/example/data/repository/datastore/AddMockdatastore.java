package com.example.data.repository.datastore;

import com.example.data.repository.datastore.interfacedata.Adddatastore;
import com.example.domain.AddUsecase;
import com.example.domain.entity.HobbyEntity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Zlink on 14/3/2560.
 */

public class AddMockdatastore implements Adddatastore {
    @Override
    public Observable<AddUsecase.ResponsValue> adddata(AddUsecase.RequestValue requestValue) {

        HobbyEntity.getInstance().setCook(requestValue.getCook());
        HobbyEntity.getInstance().setGame(requestValue.getGame());
        HobbyEntity.getInstance().setSport(requestValue.getSport());
        HobbyEntity.getInstance().setWatch(requestValue.getWatch());

        return Observable.create(new ObservableOnSubscribe<AddUsecase.ResponsValue>() {
            @Override
            public void subscribe(ObservableEmitter<AddUsecase.ResponsValue> e) throws Exception {
                AddUsecase.ResponsValue responsValue = new AddUsecase.ResponsValue();
                responsValue.setStatus("OK");
                e.onNext(responsValue);
                e.onComplete();
            }
        });
    }
}
