package com.testing.android.proof.data.database;

import com.testing.android.proof.data.database.dao.EmployeeDao;
import com.testing.android.proof.data.database.dao.EmployeeSpecialtyRelationDao;
import com.testing.android.proof.data.database.dao.SpecialtyDao;
import com.testing.android.proof.data.database.entity.EmployeeEntity;
import com.testing.android.proof.data.database.entity.EmployeeSpecialtyRelationEntity;
import com.testing.android.proof.data.database.entity.SpecialtyEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@TypeConverters({Converters.class})
@Database(entities = {
        EmployeeEntity.class,
        SpecialtyEntity.class,
        EmployeeSpecialtyRelationEntity.class
}, version = 1, exportSchema = false)
public abstract class ProofDB extends RoomDatabase {
    public static final String DATABASE_NAME = "proof_db";

    public abstract SpecialtyDao specialtyDao();

    public abstract EmployeeDao employeeDao();

    public abstract EmployeeSpecialtyRelationDao employeeSpecialtyRelationDao();
}