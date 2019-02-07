package com.testing.android.proof.domain.specialtylist;

import dagger.Binds;
import dagger.Module;

@Module
public interface SpecialtyListDomainModule {
    @Binds
    SpecialtyListInteractor provideInteractor(SpecialtyListModel interactor);
}
