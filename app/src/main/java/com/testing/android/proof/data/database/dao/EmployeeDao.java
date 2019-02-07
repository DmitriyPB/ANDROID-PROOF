package com.testing.android.proof.data.database.dao;

import com.testing.android.proof.data.database.entity.EmployeeEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface EmployeeDao {
    @Query("DELETE FROM employee")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertEmployee(EmployeeEntity employee);

    @Query("SELECT employee.* FROM employee_specialty_relation relation  " +
            "left join employee " +
            "on relation.employeeId = employee.id " +
            "where relation.specialtyId = :specialtyId")
    List<EmployeeEntity> getEmployeesBySpecialtyId(int specialtyId);

    @Query("SELECT * FROM employee where employee.id = :employeeId")
    EmployeeEntity getEmployeeById(int employeeId);
}
