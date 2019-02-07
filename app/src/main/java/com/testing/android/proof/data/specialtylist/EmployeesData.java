package com.testing.android.proof.data.specialtylist;

import com.testing.android.proof.data.database.entity.EmployeeEntity;
import com.testing.android.proof.data.database.entity.SpecialtyEntity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class EmployeesData {
    private final Set<SpecialtyEntity> specialtiesSet = new HashSet<>();
    private final Map<EmployeeEntity, Set<Integer>> employeeSpecialtyIdsMap = new HashMap<>();

    public void putEmployee(EmployeeEntity employee, Set<Integer> employeesSpecialtyIds) {
        employeeSpecialtyIdsMap.put(employee, employeesSpecialtyIds);
    }

    public void putSpecialty(SpecialtyEntity specialty) {
        specialtiesSet.add(specialty);
    }

    public Set<SpecialtyEntity> getSpecialtiesSet() {
        return specialtiesSet;
    }

    public Map<EmployeeEntity, Set<Integer>> getEmployeeSpecialtyIdsMap() {
        return employeeSpecialtyIdsMap;
    }

}
