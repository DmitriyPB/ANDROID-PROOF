package com.testing.android.proof.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(tableName = "employee_specialty_relation",
        primaryKeys = {"employeeId", "specialtyId"})
public final class EmployeeSpecialtyRelationEntity {
    private int employeeId;
    private int specialtyId;

    @Ignore
    public EmployeeSpecialtyRelationEntity(int employeeId, int specialtyId) {
        this.employeeId = employeeId;
        this.specialtyId = specialtyId;
    }

    public EmployeeSpecialtyRelationEntity() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeSpecialtyRelationEntity)) return false;

        EmployeeSpecialtyRelationEntity that = (EmployeeSpecialtyRelationEntity) o;

        if (employeeId != that.employeeId) return false;
        return specialtyId == that.specialtyId;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + specialtyId;
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "EmployeeSpecialtyRelationEntity{" +
                "employeeId=" + employeeId +
                ", specialtyId=" + specialtyId +
                '}';
    }
}
