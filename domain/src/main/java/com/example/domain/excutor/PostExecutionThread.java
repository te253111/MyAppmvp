package com.example.domain.excutor;

import io.reactivex.Scheduler;

/**
 * Created by Zlink on 7/3/2560.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
