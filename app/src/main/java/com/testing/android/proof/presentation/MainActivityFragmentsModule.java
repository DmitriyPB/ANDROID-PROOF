package com.testing.android.proof.presentation;

import com.testing.android.proof.annotations.PerFragment;
import com.testing.android.proof.presentation.employeedetails.EmployeeDetailsFragment;
import com.testing.android.proof.presentation.employeedetails.EmployeeDetailsModule;
import com.testing.android.proof.presentation.employeelist.EmployeeListFragment;
import com.testing.android.proof.presentation.employeelist.EmployeeListModule;
import com.testing.android.proof.presentation.specialtylist.SpecialtyListFragment;
import com.testing.android.proof.presentation.specialtylist.SpecialtyListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityFragmentsModule {

    @PerFragment
    @ContributesAndroidInjector(modules = SpecialtyListModule.class)
    SpecialtyListFragment provideSpecialtyListFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = EmployeeListModule.class)
    EmployeeListFragment provideEmployeeListFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = EmployeeDetailsModule.class)
    EmployeeDetailsFragment provideEmployeeDetailsFragment();
}
