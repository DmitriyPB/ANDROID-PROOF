package com.testing.android.proof.domain.employeelist;

import dagger.Binds;
import dagger.Module;

@Module
public interface EmployeeListDomainModule {
    @Binds
    EmployeeListInteractor provideInteractor(EmployeeListModel interactor);
}
