package com.testing.android.proof.domain.employeedetails;

import com.testing.android.proof.data.database.entity.EmployeeEntity;
import com.testing.android.proof.domain.Employee;
import com.testing.android.proof.domain.specialtylist.Specialty;

import java.util.List;

public final class EmployeeWithSpecialties {
    private final Employee employee;
    private final List<Specialty> specialtyEntities;

    public EmployeeWithSpecialties(EmployeeEntity employee, List<Specialty> specialtyEntities) {
        this.employee = employee;
        this.specialtyEntities = specialtyEntities;
    }

    public Employee getEmployee() {
        return employee;
    }

    public List<Specialty> getSpecialties() {
        return specialtyEntities;
    }
}
