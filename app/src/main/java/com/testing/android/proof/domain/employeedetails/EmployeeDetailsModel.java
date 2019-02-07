package com.testing.android.proof.domain.employeedetails;

import com.testing.android.proof.domain.EmployeesMapper;

import javax.inject.Inject;

import io.reactivex.Single;

public final class EmployeeDetailsModel implements EmployeeDetailsInteractor {

    private final EmployeeDetailsRepository repository;
    private final EmployeesMapper mapper;

    @Inject
    public EmployeeDetailsModel(EmployeeDetailsRepository repository, EmployeesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Single<EmployeeDetailsItem> loadEmployeeDetailsById(int employeeId) {
        return repository.loadEmployeeDetailsById(employeeId)
                .map(mapper::toEmployeeItem);
    }
}
