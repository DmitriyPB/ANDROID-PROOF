package com.testing.android.proof.data.employeelist;

import com.testing.android.proof.data.database.dao.EmployeeDao;
import com.testing.android.proof.domain.Employee;
import com.testing.android.proof.domain.employeelist.EmployeeListRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public final class EmployeeListRepositoryImpl implements EmployeeListRepository {

    private final EmployeeDao employeeDao;

    @Inject
    public EmployeeListRepositoryImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Single<List<Employee>> loadEmployeeBySpecialtyId(int specialtyId) {
        return Single.fromCallable(() -> employeeDao.getEmployeesBySpecialtyId(specialtyId))
                .map(ArrayList<Employee>::new);
    }
}
