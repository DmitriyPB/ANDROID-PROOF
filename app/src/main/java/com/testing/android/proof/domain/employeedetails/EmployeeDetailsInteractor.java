package com.testing.android.proof.domain.employeedetails;

import io.reactivex.Single;

public interface EmployeeDetailsInteractor {
    Single<EmployeeDetailsItem> loadEmployeeDetailsById(int employeeId);
}
