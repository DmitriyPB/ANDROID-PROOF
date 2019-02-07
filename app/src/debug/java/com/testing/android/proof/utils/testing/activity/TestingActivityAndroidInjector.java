package com.testing.android.proof.utils.testing.activity;


import javax.inject.Provider;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

class TestingActivityAndroidInjector implements AndroidInjector<TestingActivity> {

    private final DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    private final Provider<Fragment> initialFragmentProvider;

    TestingActivityAndroidInjector(DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector, Provider<Fragment> initialFragmentProvider) {
        this.fragmentDispatchingAndroidInjector = fragmentDispatchingAndroidInjector;
        this.initialFragmentProvider = initialFragmentProvider;
    }

    @Override
    public void inject(TestingActivity instance) {
        instance.initialFragmentProvider = initialFragmentProvider;
        instance.fragmentDispatchingAndroidInjector = fragmentDispatchingAndroidInjector;
    }
}
