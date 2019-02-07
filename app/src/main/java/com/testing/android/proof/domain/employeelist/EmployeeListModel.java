package com.testing.android.proof.domain.employeelist;

import com.testing.android.proof.domain.EmployeesMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public final class EmployeeListModel implements EmployeeListInteractor {

    private final EmployeeListRepository repository;
    private final EmployeesMapper mapper;

    @Inject
    public EmployeeListModel(EmployeeListRepository repository, EmployeesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Single<List<EmployeeListItem>> loadEmployeeListWithSpecialty(int specialtyId) {
        return repository.loadEmployeeBySpecialtyId(specialtyId)
                .map(mapper::toEmployeeListItems);
    }
}
