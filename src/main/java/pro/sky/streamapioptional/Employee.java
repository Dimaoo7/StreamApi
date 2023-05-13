package pro.sky.streamapioptional;

import java.util.Objects;

public class Employee {
    private final String fullName;
    private final int salary;
    private final int department;

    public Employee(String fullName, int salary, int department) {
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }


    public String getFullName() {
        return fullName;
    }


    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return fullName.equals(employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return   "Имя и Фамилия: " + fullName +
                " зарплата: " + salary +
                " отдел: " + department;
    }


}