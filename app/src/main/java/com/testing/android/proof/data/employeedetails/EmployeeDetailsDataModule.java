package com.testing.android.proof.data.employeedetails;

import com.testing.android.proof.domain.employeedetails.EmployeeDetailsRepository;

import dagger.Binds;
import dagger.Module;

@Module
public interface EmployeeDetailsDataModule {
    @Binds
    EmployeeDetailsRepository provideRepository(EmployeeDetailsRepositoryImpl repository);
}
