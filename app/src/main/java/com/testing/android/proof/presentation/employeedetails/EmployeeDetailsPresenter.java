package com.testing.android.proof.presentation.employeedetails;

import com.arellomobile.mvp.MvpPresenter;

public abstract class EmployeeDetailsPresenter extends MvpPresenter<EmployeeDetailsView> {
    abstract void loadEmployeeDetails(int employeeId);
}