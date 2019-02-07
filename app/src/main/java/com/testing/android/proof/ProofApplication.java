package com.testing.android.proof;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.VisibleForTesting;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import static androidx.annotation.VisibleForTesting.PACKAGE_PRIVATE;

public final class ProofApplication extends Application implements HasActivityInjector {

    @VisibleForTesting(otherwise = PACKAGE_PRIVATE)
    @Inject
    public DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    public ProofApplication() {
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .application(this)
                .build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
