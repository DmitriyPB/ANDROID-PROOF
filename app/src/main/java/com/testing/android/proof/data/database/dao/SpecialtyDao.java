package com.testing.android.proof.data.database.dao;

import com.testing.android.proof.data.database.entity.SpecialtyEntity;

import java.util.List;
import java.util.Set;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface SpecialtyDao {

    @Query("SELECT * FROM specialty")
    List<SpecialtyEntity> getAllSpecialties();

    @Query("DELETE FROM specialty")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpecialties(Set<SpecialtyEntity> specialties);

    @Query("SELECT specialty.* FROM employee_specialty_relation relation  " +
            "left join specialty " +
            "on relation.specialtyId = specialty.id " +
            "where relation.employeeId = :employeeId")
    List<SpecialtyEntity> getSpecialtiesByEmployeeId(int employeeId);
}
