package com.testing.android.proof.presentation.employeedetails;

import com.arellomobile.mvp.InjectViewState;
import com.testing.android.proof.domain.employeedetails.EmployeeDetailsInteractor;
import com.testing.android.proof.utils.rxschedulers.SchedulersProvider;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public final class EmployeeDetailsPresenterImpl extends EmployeeDetailsPresenter {

    private final EmployeeDetailsInteractor interactor;
    private final SchedulersProvider schedulers;
    private Disposable subscriptionEmployeeDetails;

    @Inject
    public EmployeeDetailsPresenterImpl(EmployeeDetailsInteractor interactor, SchedulersProvider schedulers) {
        this.interactor = interactor;
        this.schedulers = schedulers;
    }

    @Override
    public void loadEmployeeDetails(int employeeId) {
        disposeSubscriptionSafely();
        subscriptionEmployeeDetails = interactor.loadEmployeeDetailsById(employeeId)
                .subscribeOn(schedulers.ioScheduler())
                .observeOn(schedulers.uiScheduler())
                .subscribe(getViewState()::applyEmployeeDetails, this::onLoadFailure);
    }

    @Override
    public void onDestroy() {
        disposeSubscriptionSafely();
        super.onDestroy();
    }

    private void disposeSubscriptionSafely() {
        if (subscriptionEmployeeDetails != null && !subscriptionEmployeeDetails.isDisposed()) {
            subscriptionEmployeeDetails.dispose();
        }
    }

    private void onLoadFailure(Throwable throwable) {
        throwable.printStackTrace();
        getViewState().showEmployeeDetailsLoadingFailed();
    }
}
