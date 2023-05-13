package pro.sky.streamapioptional.service;

import org.springframework.stereotype.Service;
import pro.sky.streamapioptional.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptService {

    static EmployeeService employeeService;

    public DeptService(EmployeeService employeeService) {
        DeptService.employeeService = employeeService;
    }

    public static Employee max(int dept){
        return employeeService.employeeList.values().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public static Employee min(int dept){
        return employeeService.employeeList.values().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public static List<Employee> getAllEmployees(){
        return employeeService.employeeList.values().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }

    public static List<Employee> getAllEmployeesByDept(int dept){
        return employeeService.employeeList.values().stream()
                .filter(employee -> employee.getDepartment() == dept)
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());
    }
}

