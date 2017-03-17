package com.example.zlink.myappmvp.add.tab2;

import com.example.domain.ResUsecase;
import com.example.zlink.myappmvp.add.model.Hobby;
import com.example.zlink.myappmvp.add.model.HobbyMapper;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Zlink on 14/3/2560.
 */

public class ResPresenter implements ResContract.Presenter {
    private ResContract.View view;


    @Inject
    ResUsecase resUsecase;

    @Inject
    HobbyMapper hobbyMapper;

    @Inject
    public ResPresenter(){}

    @Override
    public void setView(ResContract.View view) {
        this.view = view;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void prepareDatatoshow() {
        ResUsecase.RequestValue requestValue = new ResUsecase.RequestValue();
        requestValue.setId("0");
        resUsecase.execute(requestValue,new ResUsecaseObserver());

    }


    class ResUsecaseObserver extends DisposableObserver<ResUsecase.ResponsValue>{

        @Override
        public void onNext(ResUsecase.ResponsValue value) {
            view.showdata(hobbyMapper.transform(value.getHobbyEntity()));
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
