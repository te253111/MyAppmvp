package com.example.domain;

import com.example.domain.entity.DataUserEntity;
import com.example.domain.excutor.PostExecutionThread;
import com.example.domain.resoitory.Domainrepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Zlink on 14/3/2560.
 */

public class DetailUsecase extends BaseUsecase<DetailUsecase.ResponsValue,DetailUsecase.RequestValue> {


    private Domainrepository domainrepository;

    @Inject
    public DetailUsecase(PostExecutionThread postExecutionThread, Domainrepository domainrepository) {
        super(postExecutionThread);
        this.domainrepository = domainrepository;
    }

    @Override
    protected Observable<ResponsValue> Buildobservable(RequestValue requestValue) {
        return domainrepository.getDetail(requestValue);
    }




    public static class RequestValue{
        String limit;

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }
    }

    public static class ResponsValue{
        List<DataUserEntity> dataUser;

        public List<DataUserEntity> getDataUser() {
            return dataUser;
        }

        public void setDataUser(List<DataUserEntity> dataUser) {
            this.dataUser = dataUser;
        }
    }
}
