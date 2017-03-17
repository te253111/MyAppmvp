package com.example.data.repository.datastore;

import com.example.data.repository.datastore.interfacedata.Detaildatastore;
import com.example.domain.DetailUsecase;
import com.example.domain.entity.DataUserEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Zlink on 14/3/2560.
 */

public class DetailMockdatastore implements Detaildatastore {

    List<DataUserEntity> userEntities = new ArrayList<>();

    @Override
    public Observable<DetailUsecase.ResponsValue> getDetail(DetailUsecase.RequestValue requestValue) {
        init();
        return Observable.create(new ObservableOnSubscribe<DetailUsecase.ResponsValue>() {
            @Override
            public void subscribe(ObservableEmitter<DetailUsecase.ResponsValue> e) throws Exception {
                DetailUsecase.ResponsValue responsValue = new DetailUsecase.ResponsValue();
                responsValue.setDataUser(userEntities);
                e.onNext(responsValue);
                e.onComplete();
            }
        });
    }

    private void init(){
        userEntities.add(new DataUserEntity("1", "john", "18", "2000-01-01","1","non","thai"));
        userEntities.add(new DataUserEntity("2", "red", "20", "2000-01-02","2","non","thai"));
        userEntities.add(new DataUserEntity("3", "mark", "26", "2000-03-01","3","non","thai"));
        userEntities.add(new DataUserEntity("4", "Ted", "53", "2000-01-02","4","non","thai"));
        userEntities.add(new DataUserEntity("5", "Brown", "11", "2000-01-04","5","non","thai"));
        userEntities.add(new DataUserEntity("6", "Hennry", "33", "2000-01-05","6","non","thai"));
        userEntities.add(new DataUserEntity("7", "tercy", "50", "2000-01-06","7","non","thai"));
        userEntities.add(new DataUserEntity("8", "Marco", "45", "2000-01-07","8","non","thai"));
        userEntities.add(new DataUserEntity("9", "Bruno", "33", "2000-01-08","9","non","thai"));
        userEntities.add(new DataUserEntity("10", "boy", "23", "2000-01-09","10","non","thai"));
        userEntities.add(new DataUserEntity("11", "joey", "24", "2000-01-10","11","non","thai"));
        userEntities.add(new DataUserEntity("12", "stephen", "60", "2000-06-01","12","non","thai"));
        userEntities.add(new DataUserEntity("13", "steve", "12", "2000-07-01","13","non","thai"));
        userEntities.add(new DataUserEntity("14", "alice", "19", "2000-09-01","14","non","thai"));
        userEntities.add(new DataUserEntity("15", "meena", "20", "2000-10-01","15","non","thai"));
        userEntities.add(new DataUserEntity("16", "brave", "29", "2000-11-01","16","non","thai"));
        userEntities.add(new DataUserEntity("17", "chaton", "28", "2000-12-01","17","non","thai"));
        userEntities.add(new DataUserEntity("18", "aloha", "31", "2000-02-022","18","non","thai"));
        userEntities.add(new DataUserEntity("19", "minny", "36", "2000-01-03","19","non","thai"));
        userEntities.add(new DataUserEntity("20", "toon", "55", "2000-01-22","20","non","thai"));
    }
}
