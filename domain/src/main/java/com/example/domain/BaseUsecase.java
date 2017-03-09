package com.example.domain;

import com.example.domain.excutor.PostExecutionThread;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Zlink on 8/3/2560.
 */

public abstract class BaseUsecase<T,Request> {
    private PostExecutionThread postExecutionThread;
    protected abstract Observable<T> Buildobservable(Request request);

    public  BaseUsecase(PostExecutionThread postExecutionThread){
        this.postExecutionThread = postExecutionThread;
    }

    public void execute(Request request,Observer<T> observer){
        Observable<T> observable1 = Buildobservable(request);

        observable1.subscribeOn(Schedulers.newThread())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(observer);
    }
}
