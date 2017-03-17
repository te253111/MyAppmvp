package com.example.domain.resoitory;

import com.example.domain.AddUsecase;
import com.example.domain.DetailUsecase;
import com.example.domain.LoginUsecase;
import com.example.domain.ResUsecase;

import io.reactivex.Observable;

/**
 * Created by Zlink on 8/3/2560.
 */

public interface Domainrepository {
    public Observable<LoginUsecase.ResponsValue> chklogin(LoginUsecase.RequestValue requestValue);
    public Observable<DetailUsecase.ResponsValue> getDetail(DetailUsecase.RequestValue requestValue);
    public Observable<AddUsecase.ResponsValue> adddata(AddUsecase.RequestValue requestValue);
    public Observable<ResUsecase.ResponsValue> getresult(ResUsecase.RequestValue requestValue);
}
