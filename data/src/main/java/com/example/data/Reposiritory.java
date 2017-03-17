package com.example.data;

import com.example.data.repository.datastore.AddMockdatastore;
import com.example.data.repository.datastore.DetailMockdatastore;
import com.example.data.repository.datastore.ResMockdatastore;
import com.example.data.repository.datastore.interfacedata.Adddatastore;
import com.example.data.repository.datastore.interfacedata.Detaildatastore;
import com.example.data.repository.datastore.LoginBooleandatastore;
import com.example.data.repository.datastore.interfacedata.Logindatastore;
import com.example.data.repository.datastore.interfacedata.ResDatastore;
import com.example.domain.AddUsecase;
import com.example.domain.DetailUsecase;
import com.example.domain.LoginUsecase;
import com.example.domain.ResUsecase;
import com.example.domain.resoitory.Domainrepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Zlink on 8/3/2560.
 */
@Singleton
public class Reposiritory implements Domainrepository {
    @Inject
    public Reposiritory(){

    }

    @Override
    public Observable<LoginUsecase.ResponsValue> chklogin(LoginUsecase.RequestValue requestValue) {
        Logindatastore  data = new LoginBooleandatastore();
        return data.chklogin(requestValue);
    }

    @Override
    public Observable<DetailUsecase.ResponsValue> getDetail(DetailUsecase.RequestValue requestValue) {
        Detaildatastore data = new DetailMockdatastore();
        return data.getDetail(requestValue);
    }

    @Override
    public Observable<AddUsecase.ResponsValue> adddata(AddUsecase.RequestValue requestValue) {
        Adddatastore data = new  AddMockdatastore();
        return data.adddata(requestValue);
    }

    @Override
    public Observable<ResUsecase.ResponsValue> getresult(ResUsecase.RequestValue requestValue) {
        ResDatastore data = new ResMockdatastore();
        return data.getresult(requestValue);
    }
}
