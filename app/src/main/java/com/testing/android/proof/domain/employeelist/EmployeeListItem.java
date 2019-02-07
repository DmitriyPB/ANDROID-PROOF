package com.testing.android.proof.domain.employeelist;

import androidx.annotation.NonNull;

public final class EmployeeListItem {
    private final int employeeId;
    private final String fullName;
    private final String age;

    public EmployeeListItem(int employeeId, String fullName, String age) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.age = age;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeListItem)) return false;

        EmployeeListItem that = (EmployeeListItem) o;

        if (getEmployeeId() != that.getEmployeeId()) return false;
        if (getFullName() != null ? !getFullName().equals(that.getFullName()) : that.getFullName() != null)
            return false;
        return getAge() != null ? getAge().equals(that.getAge()) : that.getAge() == null;
    }

    @Override
    public int hashCode() {
        int result = getEmployeeId();
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "EmployeeListItem{" +
                "employeeId=" + employeeId +
                ", fullName='" + fullName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
