package com.testing.android.proof.data.employeedetails;

import com.testing.android.proof.data.database.ProofDB;
import com.testing.android.proof.data.database.dao.EmployeeDao;
import com.testing.android.proof.data.database.dao.SpecialtyDao;
import com.testing.android.proof.domain.employeedetails.EmployeeDetailsRepository;
import com.testing.android.proof.domain.employeedetails.EmployeeWithSpecialties;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Single;

public final class EmployeeDetailsRepositoryImpl implements EmployeeDetailsRepository {

    private final EmployeeDao employeeDao;
    private final SpecialtyDao specialtyDao;
    private final ProofDB db;

    @Inject
    public EmployeeDetailsRepositoryImpl(EmployeeDao employeeDao, SpecialtyDao specialtyDao, ProofDB db) {
        this.employeeDao = employeeDao;
        this.specialtyDao = specialtyDao;
        this.db = db;
    }

    @Override
    public Single<EmployeeWithSpecialties> loadEmployeeDetailsById(int employeeId) {
        return Single.fromCallable(() -> getEmployeeWithSpecialties(employeeId));
    }

    private EmployeeWithSpecialties getEmployeeWithSpecialties(int employeeId) {
        return db.runInTransaction(() -> new EmployeeWithSpecialties(
                employeeDao.getEmployeeById(employeeId),
                new ArrayList<>(specialtyDao.getSpecialtiesByEmployeeId(employeeId))
        ));
    }
}
