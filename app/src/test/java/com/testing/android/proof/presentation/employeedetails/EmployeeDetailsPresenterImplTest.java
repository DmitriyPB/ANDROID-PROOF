package com.testing.android.proof.presentation.employeedetails;

import com.testing.android.proof.domain.employeedetails.EmployeeDetailsInteractor;
import com.testing.android.proof.domain.employeedetails.EmployeeDetailsItem;
import com.testing.android.proof.utils.rxschedulers.SchedulersProvider;
import com.testing.android.proof.utils.rxschedulers.SequentialSchedulersProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Single;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public final class EmployeeDetailsPresenterImplTest {

    @Mock
    private EmployeeDetailsInteractor mockInteractor;
    @Mock
    private EmployeeDetailsView mockView;

    private EmployeeDetailsPresenterImpl presenter;
    private final SchedulersProvider schedulers = new SequentialSchedulersProvider();
    private final int employeeId = 121;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        presenter = new EmployeeDetailsPresenterImpl(mockInteractor, schedulers);
        presenter.attachView(mockView);
    }

    @Test
    public void testEmployeeDetailsLoadingWithSuccess() {
        EmployeeDetailsItem employeeDetailsItem = new EmployeeDetailsItem("name", "surname", "birthdate", "age", "spec");

        when(mockInteractor.loadEmployeeDetailsById(employeeId)).thenReturn(Single.just(employeeDetailsItem));

        presenter.loadEmployeeDetails(employeeId);

        verify(mockInteractor).loadEmployeeDetailsById(employeeId);
        verify(mockView).applyEmployeeDetails(employeeDetailsItem);
    }

    @Test
    public void testEmployeeDetailsLoadingWithFailure() {
        when(mockInteractor.loadEmployeeDetailsById(employeeId))
                .thenReturn(Single.error(Exception::new));

        presenter.loadEmployeeDetails(employeeId);

        verify(mockInteractor).loadEmployeeDetailsById(employeeId);
        verify(mockView).showEmployeeDetailsLoadingFailed();
    }
}