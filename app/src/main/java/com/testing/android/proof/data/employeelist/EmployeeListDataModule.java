package com.testing.android.proof.data.employeelist;

import com.testing.android.proof.domain.employeelist.EmployeeListRepository;

import dagger.Binds;
import dagger.Module;

@Module
public interface EmployeeListDataModule {
    @Binds
    EmployeeListRepository provideRepository(EmployeeListRepositoryImpl repository);
}
