package com.testing.android.proof.domain.employeedetails;

import io.reactivex.Single;

public interface EmployeeDetailsRepository {
    Single<EmployeeWithSpecialties> loadEmployeeDetailsById(int employeeId);
}
