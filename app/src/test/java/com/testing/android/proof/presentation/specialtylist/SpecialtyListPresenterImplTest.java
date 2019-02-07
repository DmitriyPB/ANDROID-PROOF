package com.testing.android.proof.presentation.specialtylist;

import com.testing.android.proof.domain.specialtylist.SpecialtyItem;
import com.testing.android.proof.domain.specialtylist.SpecialtyListInteractor;
import com.testing.android.proof.utils.rxschedulers.SchedulersProvider;
import com.testing.android.proof.utils.rxschedulers.SequentialSchedulersProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public final class SpecialtyListPresenterImplTest {

    @Mock
    private SpecialtyListInteractor mockInteractor;
    @Mock
    private SpecialtyListView mockView;

    private SpecialtyListPresenterImpl presenter;
    private final SchedulersProvider schedulers = new SequentialSchedulersProvider();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitialSpecialtiesLoadingWithSuccess() {
        List<SpecialtyItem> specialtyItemList = Arrays.asList(
                new SpecialtyItem(1, "Пилот"),
                new SpecialtyItem(2, "Не пилот")
        );
        when(mockInteractor.loadSpecialties()).thenReturn(Single.just(specialtyItemList));
        presenter = new SpecialtyListPresenterImpl(mockInteractor, schedulers);
        presenter.attachView(mockView);

        verify(mockInteractor).loadSpecialties();
        verify(mockView).applySpecialties(specialtyItemList);
    }

    @Test
    public void testInitialSpecialtiesLoadingWithFailure() {
        when(mockInteractor.loadSpecialties())
                .thenReturn(Single.error(Exception::new));
        presenter = new SpecialtyListPresenterImpl(mockInteractor, schedulers);
        presenter.attachView(mockView);

        verify(mockInteractor).loadSpecialties();
        verify(mockView).showSpecialtiesLoadingError();
    }
}