package com.testing.android.proof.utils.testing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

@SuppressLint("Registered")
public final class TestingApplication extends Application implements HasActivityInjector {

    @Inject
    public DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
