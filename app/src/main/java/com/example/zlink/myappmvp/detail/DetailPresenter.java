package com.example.zlink.myappmvp.detail;

import com.example.domain.DetailUsecase;
import com.example.zlink.myappmvp.detail.model.DataUser;
import com.example.zlink.myappmvp.detail.model.DataUserMapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Zlink on 9/3/2560.
 */

public class DetailPresenter implements DetailContract.Presenter {


    private DetailContract.View view;




    @Inject
    public DetailPresenter() {

    }

    @Inject
    DetailUsecase detailUsecase;
    @Inject
    DataUserMapper dataUserMapper;

    @Override
    public void setView(DetailContract.View view) {
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
    public void getDataUser() {
        DetailUsecase.RequestValue requestValue = new DetailUsecase.RequestValue();
        requestValue.setLimit("0");
        detailUsecase.execute(requestValue,new DetailUsecaseObserver());
    }



    class DetailUsecaseObserver extends DisposableObserver<DetailUsecase.ResponsValue>{

        @Override
        public void onNext(DetailUsecase.ResponsValue value) {
            view.SetDataUser(dataUserMapper.transform(value.getDataUser()));
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
