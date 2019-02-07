package com.testing.android.proof.presentation.specialtylist;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.testing.android.proof.domain.specialtylist.SpecialtyItem;

import java.util.List;

import androidx.annotation.NonNull;

interface SpecialtyListView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void applySpecialties(@NonNull List<SpecialtyItem> specialties);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showSpecialtiesLoadingError();
}
