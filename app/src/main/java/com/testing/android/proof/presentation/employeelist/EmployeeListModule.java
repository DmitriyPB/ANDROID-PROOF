package com.testing.android.proof.presentation.employeelist;

import dagger.Binds;
import dagger.Module;

@Module
public interface EmployeeListModule {
    @Binds
    EmployeeListPresenter providePresenter(EmployeeListPresenterImpl presenter);
}
