package com.testing.android.proof.presentation.specialtylist;

import dagger.android.AndroidInjector;

class SpecialtyListFragmentInjector implements AndroidInjector<SpecialtyListFragment> {

    private final SpecialtyListPresenter presenter;

    SpecialtyListFragmentInjector(SpecialtyListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void inject(SpecialtyListFragment instance) {
        instance.presenterProvider = () -> presenter;
    }
}
