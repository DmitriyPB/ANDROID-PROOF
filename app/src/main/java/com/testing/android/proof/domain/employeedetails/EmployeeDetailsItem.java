package com.testing.android.proof.domain.employeedetails;

import androidx.annotation.NonNull;

public final class EmployeeDetailsItem {
    private final String name;
    private final String surname;
    private final String birthdate;
    private final String age;
    private final String specialty;

    public EmployeeDetailsItem(String name, String surname, String birthdate, String age, String specialty) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.age = age;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAge() {
        return age;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDetailsItem)) return false;

        EmployeeDetailsItem that = (EmployeeDetailsItem) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
            return false;
        if (getSurname() != null ? !getSurname().equals(that.getSurname()) : that.getSurname() != null)
            return false;
        if (getBirthdate() != null ? !getBirthdate().equals(that.getBirthdate()) : that.getBirthdate() != null)
            return false;
        if (getAge() != null ? !getAge().equals(that.getAge()) : that.getAge() != null)
            return false;
        return getSpecialty() != null ? getSpecialty().equals(that.getSpecialty()) : that.getSpecialty() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getBirthdate() != null ? getBirthdate().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getSpecialty() != null ? getSpecialty().hashCode() : 0);
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "EmployeeDetailsItem{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", age='" + age + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
