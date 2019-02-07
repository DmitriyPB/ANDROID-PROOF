package com.testing.android.proof.data.specialtylist;

import com.testing.android.proof.domain.specialtylist.SpecialtyListRepository;

import dagger.Binds;
import dagger.Module;

@Module
public interface SpecialtyListDataModule {
    @Binds
    SpecialtyListRepository provideRepository(SpecialtyListRepositoryImpl repository);
}
