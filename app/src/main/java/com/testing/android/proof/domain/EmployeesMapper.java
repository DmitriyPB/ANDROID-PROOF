package com.testing.android.proof.domain;

import android.annotation.SuppressLint;

import com.testing.android.proof.domain.employeedetails.EmployeeDetailsItem;
import com.testing.android.proof.domain.employeedetails.EmployeeWithSpecialties;
import com.testing.android.proof.domain.employeelist.EmployeeListItem;
import com.testing.android.proof.domain.specialtylist.Specialty;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import static com.testing.android.proof.domain.AgeUtils.getAge;
import static java.lang.String.valueOf;

public final class EmployeesMapper {

    @SuppressLint("SimpleDateFormat")
    private final static SimpleDateFormat printDateFormat = new SimpleDateFormat("dd.MM.yyyy г.");
    private final static String dash = "-";

    @Inject
    public EmployeesMapper() {}

    public List<EmployeeListItem> toEmployeeListItems(List<Employee> employees) {
        ArrayList<EmployeeListItem> employeeListItems = new ArrayList<>(employees.size());
        for (Employee employee : employees) {
            employeeListItems.add(convertEmployeeToEmployeeListItem(employee));
        }
        return employeeListItems;
    }

    public EmployeeDetailsItem toEmployeeItem(EmployeeWithSpecialties employeeEntity) {
        return new EmployeeDetailsItem(
                employeeEntity.getEmployee().getFirstName(),
                employeeEntity.getEmployee().getLastName(),
                formatBirthday(employeeEntity.getEmployee().getBirthday()),
                getAgeFormatted(employeeEntity.getEmployee().getBirthday()),
                buildSpecialtiesString(employeeEntity.getSpecialties())
        );
    }

    private EmployeeListItem convertEmployeeToEmployeeListItem(Employee employee) {
        return new EmployeeListItem(
                employee.getId(),
                buildFullName(employee),
                getAgeFormatted(employee.getBirthday())
        );
    }

    private String buildFullName(Employee employee) {
        return employee.getFirstName() + " " + employee.getLastName();
    }


    private String formatBirthday(Date birthday) {
        if (birthday != null) {
            return printDateFormat.format(birthday);
        }
        return dash;
    }

    private String getAgeFormatted(Date birthday) {
        if (birthday != null) {
            return valueOf(getAge(birthday));
        }
        return dash;
    }

    private String buildSpecialtiesString(List<Specialty> specialties) {
        if (specialties != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < specialties.size(); i++) {
                Specialty specialty = specialties.get(i);
                if (i != 0) sb.append(", ");
                sb.append(specialty.getName());
            }
            return sb.toString();
        }
        return "";
    }
}
