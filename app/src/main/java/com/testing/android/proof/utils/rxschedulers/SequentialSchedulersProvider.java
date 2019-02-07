package com.testing.android.proof.utils.rxschedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public final class SequentialSchedulersProvider implements SchedulersProvider {
    @Override
    public Scheduler ioScheduler() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler uiScheduler() {
        return Schedulers.trampoline();
    }
}
