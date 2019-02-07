package com.testing.android.proof.utils.rxschedulers;

import io.reactivex.Scheduler;

public interface SchedulersProvider {
    Scheduler ioScheduler();

    Scheduler uiScheduler();
}
