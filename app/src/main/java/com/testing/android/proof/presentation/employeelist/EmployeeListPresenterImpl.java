package com.testing.android.proof.presentation.employeelist;

import com.arellomobile.mvp.InjectViewState;
import com.testing.android.proof.domain.employeelist.EmployeeListInteractor;
import com.testing.android.proof.utils.rxschedulers.SchedulersProvider;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public final class EmployeeListPresenterImpl extends EmployeeListPresenter {

    private final EmployeeListInteractor interactor;
    private final SchedulersProvider schedulers;
    private Disposable subscriptionEmployeeList;

    @Inject
    public EmployeeListPresenterImpl(EmployeeListInteractor interactor, SchedulersProvider schedulers) {
        this.interactor = interactor;
        this.schedulers = schedulers;
    }

    @Override
    public void loadEmployeeList(int specialtyId) {
        disposeSubscriptionSafely();
        subscriptionEmployeeList = interactor.loadEmployeeListWithSpecialty(specialtyId)
                .subscribeOn(schedulers.ioScheduler())
                .observeOn(schedulers.uiScheduler())
                .subscribe(getViewState()::applyEmployeeList, this::onLoadFailure);
    }

    @Override
    public void onDestroy() {
        disposeSubscriptionSafely();
        super.onDestroy();
    }

    private void disposeSubscriptionSafely() {
        if (subscriptionEmployeeList != null && !subscriptionEmployeeList.isDisposed()) {
            subscriptionEmployeeList.dispose();
        }
    }

    private void onLoadFailure(Throwable throwable) {
        throwable.printStackTrace();
        getViewState().showLoadingError();
    }
}
