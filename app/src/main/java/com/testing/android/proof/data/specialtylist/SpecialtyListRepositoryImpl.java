package com.testing.android.proof.data.specialtylist;

import com.testing.android.proof.data.database.dao.EmployeeDao;
import com.testing.android.proof.data.database.entity.EmployeeEntity;
import com.testing.android.proof.data.database.dao.EmployeeSpecialtyRelationDao;
import com.testing.android.proof.data.database.entity.EmployeeSpecialtyRelationEntity;
import com.testing.android.proof.data.database.dao.SpecialtyDao;
import com.testing.android.proof.data.database.entity.SpecialtyEntity;
import com.testing.android.proof.data.specialtylist.employeeservice.EmployeeServiceResponse;
import com.testing.android.proof.domain.specialtylist.Specialty;
import com.testing.android.proof.domain.specialtylist.SpecialtyListRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.Single;

public final class SpecialtyListRepositoryImpl implements SpecialtyListRepository {

    private final EmployeeService employeeService;
    private final EmployeeDao employeeDao;
    private final SpecialtyDao specialtyDao;
    private final EmployeeSpecialtyRelationDao relationDao;
    private final EmployeesDataExtractor employeesDataExtractor;

    @Inject
    public SpecialtyListRepositoryImpl(EmployeeService employeeService,
                                       EmployeeDao employeeDao,
                                       SpecialtyDao specialtyDao,
                                       EmployeeSpecialtyRelationDao relationDao,
                                       EmployeesDataExtractor employeesDataExtractor) {
        this.employeeService = employeeService;
        this.employeeDao = employeeDao;
        this.specialtyDao = specialtyDao;
        this.relationDao = relationDao;
        this.employeesDataExtractor = employeesDataExtractor;
    }

    @Override
    public Single<List<Specialty>> loadSpecialties() {
        return Single.fromCallable(this::fetchAndProcessEmployeeDataAndGetSpecialties)
                .map(ArrayList<Specialty>::new);
    }

    private List<SpecialtyEntity> fetchAndProcessEmployeeDataAndGetSpecialties() {
        EmployeeServiceResponse employeeServiceResponse = employeeService.fetchEmployeeServiceResponse();
        EmployeesData employeesData = employeesDataExtractor.extractDataFromResponse(employeeServiceResponse);
        saveEmployeesData(employeesData);
        return specialtyDao.getAllSpecialties();
    }

    private void saveEmployeesData(EmployeesData employeesData) {
        specialtyDao.deleteAll();
        employeeDao.deleteAll();
        relationDao.deleteAll();

        Set<SpecialtyEntity> specialties = employeesData.getSpecialtiesSet();
        specialtyDao.insertSpecialties(specialties);

        Map<EmployeeEntity, Set<Integer>> employeeSpecialtyIdsMap = employeesData.getEmployeeSpecialtyIdsMap();
        for (Map.Entry<EmployeeEntity, Set<Integer>> employeeEntry : employeeSpecialtyIdsMap.entrySet()) {
            int employeeId = employeeDao.insertEmployee(employeeEntry.getKey()).intValue();
            Set<Integer> specialtyIds = employeeEntry.getValue();
            for (Integer specialtyId : specialtyIds) {
                relationDao.insertRelation(new EmployeeSpecialtyRelationEntity(employeeId, specialtyId));
            }
        }
    }
}
