package com.testing.android.proof.domain.employeelist;

import java.util.List;

import io.reactivex.Single;

public interface EmployeeListInteractor {
    Single<List<EmployeeListItem>> loadEmployeeListWithSpecialty(int specialtyId);
}
