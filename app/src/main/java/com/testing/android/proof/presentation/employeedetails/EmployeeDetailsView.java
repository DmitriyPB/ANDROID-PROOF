package com.testing.android.proof.presentation.employeedetails;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.testing.android.proof.domain.employeedetails.EmployeeDetailsItem;

import androidx.annotation.NonNull;


public interface EmployeeDetailsView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void applyEmployeeDetails(@NonNull EmployeeDetailsItem employeeDetailsItem);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showEmployeeDetailsLoadingFailed();
}
