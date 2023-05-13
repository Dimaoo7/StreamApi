package pro.sky.streamapioptional.service;

import org.springframework.stereotype.Service;
import pro.sky.streamapioptional.Employee;
import pro.sky.streamapioptional.exceptions.EmployeeAlreadyAddedException;
import pro.sky.streamapioptional.exceptions.EmployeeStorageIsFullException;
import pro.sky.streamapioptional.exceptions.EmployeeNotFoundException;
import java.util.*;


@Service
public class EmployeeService {

    protected static final Map<String, Employee> employeeList = new HashMap<>(Map.of(
            "John Doe",
            new Employee("John Doe", 1500, 1),
            "Jane Doe",
            new Employee("Jane Doe", 5000, 2),
            "Jack Doe",
            new Employee("Jack Pers", 3000, 1),
            "Kakbez Smith",
            new Employee("Kakbez Smith", 4000, 2),
            "Nyi Biden",
            new Employee("Nyi Biden", 3500, 3),
            "Johan Libert",
            new Employee("Johan Libert", 15000, 3)
    ));

        private static final int MAX_SIZE = 15;

        public static Employee add(String fullName, int salary, int department) {
            if (employeeList.size() == MAX_SIZE) {
                throw new EmployeeStorageIsFullException();
            }
            if (employeeList.containsKey(fullName.toLowerCase())) {
                throw new EmployeeAlreadyAddedException();
            }
            if (department < 1 || department > 3) {
                throw new IllegalArgumentException();
            }
            if (salary < 0) {
                throw new IllegalArgumentException();
            }
            if (fullName.isBlank()) {
                throw new IllegalArgumentException();
            }
            return employeeList.put(fullName.toLowerCase(), new Employee(fullName, salary, department));

        }

        public static Employee delete(String fullName) {
            if (!employeeList.containsKey(fullName.toLowerCase())) {
                throw new EmployeeNotFoundException();
            }
            return employeeList.remove(fullName);
        }

        public static Employee find(String fullName) {
            if (!employeeList.containsKey(fullName)) {
                throw new EmployeeNotFoundException();
            }
            return employeeList.get(fullName);
        }
    }
