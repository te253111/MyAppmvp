package com.example.zlink.myappmvp.add.tab1;

import com.example.domain.AddUsecase;
import com.example.zlink.myappmvp.add.model.Hobby;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Zlink on 14/3/2560.
 */

public class AddPresenter implements AddContract.Presenter {
    private AddContract.View view;


    @Inject
    AddUsecase addUsecase;

    @Inject
    public AddPresenter(){

    }

    @Override
    public void setView(AddContract.View view) {
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
    public void prepareDatatosave(Hobby hobby) {
        AddUsecase.RequestValue value = new AddUsecase.RequestValue();
        value.setCook(hobby.getCook());
        value.setSport(hobby.getSport());
        value.setGame(hobby.getGame());
        value.setWatch(hobby.getWatch());
        addUsecase.execute(value,new AddUsecaseObserver());
    }


    class AddUsecaseObserver extends DisposableObserver<AddUsecase.ResponsValue>{
        @Override
        public void onNext(AddUsecase.ResponsValue value) {
            view.showstatus(value.getStatus());
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}