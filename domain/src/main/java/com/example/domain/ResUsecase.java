package com.example.domain;

import com.example.domain.entity.DataUserEntity;
import com.example.domain.entity.HobbyEntity;
import com.example.domain.excutor.PostExecutionThread;
import com.example.domain.resoitory.Domainrepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Zlink on 16/3/2560.
 */

public class ResUsecase extends  BaseUsecase<ResUsecase.ResponsValue,ResUsecase.RequestValue>{


    private Domainrepository domainrepository;

    @Inject
    public ResUsecase(PostExecutionThread postExecutionThread, Domainrepository domainrepository) {
        super(postExecutionThread);
        this.domainrepository = domainrepository;
    }

    @Override
    protected Observable<ResponsValue> Buildobservable(RequestValue requestValue) {
        return domainrepository.getresult(requestValue);
    }

    public static class RequestValue{
        String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class ResponsValue{
        HobbyEntity hobbyEntity;

        public HobbyEntity getHobbyEntity() {
            return hobbyEntity;
        }

        public void setHobbyEntity(HobbyEntity hobbyEntity) {
            this.hobbyEntity = hobbyEntity;
        }
    }
}
