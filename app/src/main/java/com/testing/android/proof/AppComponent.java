package com.testing.android.proof;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(ProofApplication app);

        Builder appModule(AppModule appModule);

        AppComponent build();
    }

    void inject(ProofApplication app);
}
