package com.example.domain;

import com.example.domain.excutor.PostExecutionThread;
import com.example.domain.resoitory.Domainrepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Zlink on 14/3/2560.
 */

public class AddUsecase extends BaseUsecase<AddUsecase.ResponsValue,AddUsecase.RequestValue>{


    private Domainrepository domainrepository;

    @Inject
    public AddUsecase(PostExecutionThread postExecutionThread , Domainrepository domainrepository) {
        super(postExecutionThread);
        this.domainrepository = domainrepository;
    }

    @Override
    protected Observable<ResponsValue> Buildobservable(RequestValue requestValue) {
        return domainrepository.adddata(requestValue);
    }

    public static class RequestValue{
        String cook;
        String sport;
        String game;
        String watch;

        public String getCook() {
            return cook;
        }

        public void setCook(String cook) {
            this.cook = cook;
        }

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        public String getGame() {
            return game;
        }

        public void setGame(String game) {
            this.game = game;
        }

        public String getWatch() {
            return watch;
        }

        public void setWatch(String watch) {
            this.watch = watch;
        }
    }

    public static class ResponsValue {
        String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
