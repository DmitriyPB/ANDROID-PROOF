package com.testing.android.proof.utils.testing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Provider;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;

public final class AndroidInjectionUtils {
    private AndroidInjectionUtils() {
    }

    @SuppressWarnings("Convert2Lambda")
    public static <T> DispatchingAndroidInjector<T> buildDispatchingAndroidInjectorFromMap(final Map<Class<? extends T>, AndroidInjector<? extends T>> injectorsMap) {
        Provider<AndroidInjector.Factory<?>> injectorFactoryProvider = new Provider<AndroidInjector.Factory<?>>() {
            @Override
            public AndroidInjector.Factory<T> get() {
                return new AndroidInjector.Factory<T>() {
                    @Override
                    @SuppressWarnings({"unchecked", "SuspiciousMethodCalls"})
                    public AndroidInjector<T> create(T instance) {
                        return (AndroidInjector<T>) injectorsMap.get(instance.getClass());
                    }
                };
            }
        };

        Map<Class<?>, Provider<AndroidInjector.Factory<?>>> providersMap = new HashMap<>(1);
        for (Class<?> clazz : injectorsMap.keySet()) {
            providersMap.put(clazz, injectorFactoryProvider);
        }
        return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(providersMap, Collections.emptyMap());
    }
}
