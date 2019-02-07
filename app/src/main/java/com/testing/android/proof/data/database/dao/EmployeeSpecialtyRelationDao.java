package com.testing.android.proof.data.database.dao;

import com.testing.android.proof.data.database.entity.EmployeeSpecialtyRelationEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface EmployeeSpecialtyRelationDao {
    @Query("DELETE FROM employee_specialty_relation")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRelation(EmployeeSpecialtyRelationEntity relationEntity);
}
