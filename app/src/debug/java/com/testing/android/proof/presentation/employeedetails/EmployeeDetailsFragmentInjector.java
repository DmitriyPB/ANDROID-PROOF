package com.testing.android.proof.presentation.employeedetails;

import dagger.android.AndroidInjector;

public final class EmployeeDetailsFragmentInjector implements AndroidInjector<EmployeeDetailsFragment> {

    private final EmployeeDetailsPresenter presenter;

    public EmployeeDetailsFragmentInjector(EmployeeDetailsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void inject(EmployeeDetailsFragment instance) {
        instance.presenterProvider = () -> presenter;
    }
}
