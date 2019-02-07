package com.testing.android.proof.presentation.specialtylist;

import com.arellomobile.mvp.MvpPresenter;

abstract class SpecialtyListPresenter extends MvpPresenter<SpecialtyListView> {
    abstract void loadSpecialtyList();
}
