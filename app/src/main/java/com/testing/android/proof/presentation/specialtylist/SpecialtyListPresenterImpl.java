package com.testing.android.proof.presentation.specialtylist;

import com.arellomobile.mvp.InjectViewState;
import com.testing.android.proof.domain.specialtylist.SpecialtyListInteractor;
import com.testing.android.proof.utils.rxschedulers.SchedulersProvider;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public final class SpecialtyListPresenterImpl extends SpecialtyListPresenter {

    private final SpecialtyListInteractor interactor;
    private final SchedulersProvider schedulers;
    private Disposable subscriptionSpecialties;

    @Inject
    SpecialtyListPresenterImpl(SpecialtyListInteractor interactor, SchedulersProvider schedulers) {
        this.interactor = interactor;
        this.schedulers = schedulers;
        loadSpecialtyList();
    }

    @Override
    void loadSpecialtyList() {
        disposeSubscriptionSafely();
        subscriptionSpecialties = interactor.loadSpecialties()
                .subscribeOn(schedulers.ioScheduler())
                .observeOn(schedulers.uiScheduler())
                .subscribe(getViewState()::applySpecialties, this::onLoadFailure);
    }

    @Override
    public void onDestroy() {
        disposeSubscriptionSafely();
        super.onDestroy();
    }

    private void disposeSubscriptionSafely() {
        if (subscriptionSpecialties != null && !subscriptionSpecialties.isDisposed()) {
            subscriptionSpecialties.dispose();
        }
    }

    private void onLoadFailure(Throwable throwable) {
        throwable.printStackTrace();
        getViewState().showSpecialtiesLoadingError();
    }
}
