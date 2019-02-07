package com.testing.android.proof.presentation.specialtylist;

import dagger.Binds;
import dagger.Module;

@Module
public interface SpecialtyListModule {
    @Binds
    SpecialtyListPresenter providePresenter(SpecialtyListPresenterImpl presenter);
}

