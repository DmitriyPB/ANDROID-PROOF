package com.testing.android.proof.presentation.employeelist;

import com.testing.android.proof.domain.employeelist.EmployeeListInteractor;
import com.testing.android.proof.domain.employeelist.EmployeeListItem;
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

public final class EmployeeListPresenterImplTest {

    @Mock
    private EmployeeListInteractor mockInteractor;
    @Mock
    private EmployeeListView mockView;

    private EmployeeListPresenterImpl presenter;
    private final SchedulersProvider schedulers = new SequentialSchedulersProvider();
    private final int specialtyId = 123;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new EmployeeListPresenterImpl(mockInteractor, schedulers);
        presenter.attachView(mockView);
    }

    @Test
    public void testEmployeeListLoadingWithSuccess() {
        List<EmployeeListItem> employeeList = Arrays.asList(
                new EmployeeListItem(1, "Дамир Желтков", "20"),
                new EmployeeListItem(2, "Дамир Нежелтков", "22")
        );
        when(mockInteractor.loadEmployeeListWithSpecialty(specialtyId)).thenReturn(Single.just(employeeList));

        presenter.loadEmployeeList(specialtyId);

        verify(mockInteractor).loadEmployeeListWithSpecialty(specialtyId);
        verify(mockView).applyEmployeeList(employeeList);
    }

    @Test
    public void testEmployeeListLoadingWithFailure() {
        when(mockInteractor.loadEmployeeListWithSpecialty(specialtyId))
                .thenReturn(Single.error(Exception::new));

        presenter.loadEmployeeList(specialtyId);

        verify(mockInteractor).loadEmployeeListWithSpecialty(specialtyId);
        verify(mockView).showLoadingError();
    }
}