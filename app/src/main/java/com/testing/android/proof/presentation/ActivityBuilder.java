package com.testing.android.proof.presentation;

import com.testing.android.proof.annotations.PerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = {
            MainActivityFragmentsModule.class,
            MainActivityModule.class
    })
    MainActivity provideMainActivity();
}
