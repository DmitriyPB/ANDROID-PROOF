package com.testing.android.proof.domain.employeedetails;

import dagger.Binds;
import dagger.Module;

@Module
public interface EmployeeDetailsDomainModule {
    @Binds
    EmployeeDetailsInteractor provideInteractor(EmployeeDetailsModel interactor);
}
