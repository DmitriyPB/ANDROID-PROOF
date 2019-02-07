package com.testing.android.proof.domain;

import com.testing.android.proof.domain.employeedetails.EmployeeDetailsDomainModule;
import com.testing.android.proof.domain.employeelist.EmployeeListDomainModule;
import com.testing.android.proof.domain.specialtylist.SpecialtyListDomainModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        SpecialtyListDomainModule.class,
        EmployeeListDomainModule.class,
        EmployeeDetailsDomainModule.class
})
public final class DomainModule {
    @Singleton
    @Provides
    public EmployeesMapper provideEmployeesMapper() {
        return new EmployeesMapper();
    }
}
