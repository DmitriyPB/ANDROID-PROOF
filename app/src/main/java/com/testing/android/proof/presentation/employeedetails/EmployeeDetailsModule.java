package com.testing.android.proof.presentation.employeedetails;

import dagger.Binds;
import dagger.Module;

@Module
public interface EmployeeDetailsModule {
    @Binds
    EmployeeDetailsPresenter providePresenter(EmployeeDetailsPresenterImpl presenter);
}
