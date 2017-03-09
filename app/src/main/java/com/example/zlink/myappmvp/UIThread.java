package com.example.zlink.myappmvp;

import com.example.domain.excutor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Zlink on 7/3/2560.
 */
@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread(){}

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
