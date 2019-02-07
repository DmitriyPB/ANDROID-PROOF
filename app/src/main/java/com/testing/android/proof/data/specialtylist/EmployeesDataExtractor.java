package com.testing.android.proof.data.specialtylist;

import android.annotation.SuppressLint;

import com.testing.android.proof.data.database.entity.EmployeeEntity;
import com.testing.android.proof.data.database.entity.SpecialtyEntity;
import com.testing.android.proof.data.specialtylist.employeeservice.EmployeeServiceResponse;
import com.testing.android.proof.data.specialtylist.employeeservice.Response;
import com.testing.android.proof.data.specialtylist.employeeservice.Specialty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

class EmployeesDataExtractor {

    @Inject
    public EmployeesDataExtractor() {}

    EmployeesData extractDataFromResponse(EmployeeServiceResponse employeeServiceResponse) {
        EmployeesData employeesData = new EmployeesData();
        List<Response> responses = employeeServiceResponse.getResponse();
        for (Response response : responses) {
            Set<Integer> employeeSpecialties = new HashSet<>();
            for (Specialty specialty : response.getSpecialty()) {
                SpecialtyEntity specialtyEntity = convertResponseSpecialtyToSpecialtyEntity(specialty);
                employeeSpecialties.add(specialtyEntity.getId());
                employeesData.putSpecialty(specialtyEntity);
            }
            employeesData.putEmployee(convertResponseToEmployeeEntity(response), employeeSpecialties);
        }
        return employeesData;
    }

    private SpecialtyEntity convertResponseSpecialtyToSpecialtyEntity(Specialty specialty) {
        return new SpecialtyEntity(specialty.getSpecialtyId(), specialty.getName());
    }

    EmployeeEntity convertResponseToEmployeeEntity(Response response) {
        return new EmployeeEntity(
                capitalizeFirstLetter(response.getFName()),
                capitalizeFirstLetter(response.getLName()),
                extractDate(response.getBirthday())
        );
    }

    private String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    @SuppressLint("SimpleDateFormat")
    private final static SimpleDateFormat parseDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
    @SuppressLint("SimpleDateFormat")
    private final static SimpleDateFormat parseDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    private Date extractDate(String date) {
        if (date != null) {
            DateFormat format = parseDateFormat1;
            if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                format = parseDateFormat2;
            }
            try {
                return format.parse(date);
            } catch (Throwable ignored) {}
        }
        return null;
    }
}
