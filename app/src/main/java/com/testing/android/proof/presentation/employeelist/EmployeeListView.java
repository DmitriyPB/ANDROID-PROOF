package com.testing.android.proof.presentation.employeelist;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.testing.android.proof.domain.employeelist.EmployeeListItem;

import java.util.List;

import androidx.annotation.NonNull;


public interface EmployeeListView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void applyEmployeeList(@NonNull List<EmployeeListItem> employeeList);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showLoadingError();
}
