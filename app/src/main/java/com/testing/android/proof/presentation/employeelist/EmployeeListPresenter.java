package com.testing.android.proof.presentation.employeelist;

import com.arellomobile.mvp.MvpPresenter;

public abstract class EmployeeListPresenter extends MvpPresenter<EmployeeListView> {
    abstract void loadEmployeeList(int specialtyId);
}
