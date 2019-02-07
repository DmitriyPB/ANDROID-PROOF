package com.testing.android.proof.presentation.employeelist;

import dagger.android.AndroidInjector;

public final class EmployeeListFragmentInjector implements AndroidInjector<EmployeeListFragment> {

    private final EmployeeListPresenter presenter;

    public EmployeeListFragmentInjector(EmployeeListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void inject(EmployeeListFragment instance) {
        instance.presenterProvider = () -> presenter;
    }
}
