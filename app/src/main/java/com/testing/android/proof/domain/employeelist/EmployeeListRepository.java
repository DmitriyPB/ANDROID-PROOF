package com.testing.android.proof.domain.employeelist;

import com.testing.android.proof.domain.Employee;

import java.util.List;

import io.reactivex.Single;

public interface EmployeeListRepository {
    Single<List<Employee>> loadEmployeeBySpecialtyId(int specialtyId);
}
