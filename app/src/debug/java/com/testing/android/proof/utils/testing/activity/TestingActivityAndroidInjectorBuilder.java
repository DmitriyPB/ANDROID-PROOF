package com.testing.android.proof.utils.testing.activity;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Provider;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

import static com.testing.android.proof.utils.testing.AndroidInjectionUtils.buildDispatchingAndroidInjectorFromMap;

public final class TestingActivityAndroidInjectorBuilder {

    private final Map<Class<? extends Fragment>, AndroidInjector<? extends Fragment>> fragmentInjectorMap = new HashMap<>();
    private final Provider<Fragment> initialFragmentProvider;

    private TestingActivityAndroidInjectorBuilder(Provider<Fragment> initialFragmentProvider) { this.initialFragmentProvider = initialFragmentProvider;}

    public static TestingActivityAndroidInjectorBuilder create(Provider<Fragment> initialFragmentProvider) {
        return new TestingActivityAndroidInjectorBuilder(initialFragmentProvider);
    }

    public TestingActivityAndroidInjectorBuilder addFragmentInjector(Class<? extends Fragment> fragmentClass, AndroidInjector<? extends Fragment> fragmentInjector) {
        fragmentInjectorMap.put(fragmentClass, fragmentInjector);
        return this;
    }

    public DispatchingAndroidInjector<Activity> build() {
        DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector = buildDispatchingAndroidInjectorFromMap(fragmentInjectorMap);
        Map<Class<? extends Activity>, AndroidInjector<? extends Activity>> activityInjectorMap = new HashMap<>(1);
        activityInjectorMap.put(TestingActivity.class, new TestingActivityAndroidInjector(fragmentDispatchingAndroidInjector, initialFragmentProvider));
        return buildDispatchingAndroidInjectorFromMap(activityInjectorMap);
    }
}
