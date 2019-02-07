package com.testing.android.proof.utils.rxschedulers;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class AndroidSchedulersProvider implements SchedulersProvider {
    @Override
    public Scheduler ioScheduler() {
        return Schedulers.io();
    }

    @Override
    public Scheduler uiScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
