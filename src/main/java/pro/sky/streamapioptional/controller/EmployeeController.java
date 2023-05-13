package pro.sky.streamapioptional.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.streamapioptional.Employee;
import pro.sky.streamapioptional.service.DeptService;
import pro.sky.streamapioptional.service.EmployeeService;


@RestController
@RequestMapping("/departments")
public class EmployeeController {

    private final DeptService deptService;
    private final EmployeeService employeeService;

    public EmployeeController(DeptService deptService, EmployeeService employeeService) {
        this.deptService = deptService;
        this.employeeService = employeeService;

    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("fullName") String fullName, @RequestParam("salary") int salary, @RequestParam("departmentId") int departmentId) {
        return EmployeeService.add(fullName, salary, departmentId);
    }

    @GetMapping("/delete")
    public Employee deleteEmployee(@RequestParam("fullName") String fullName) {
        return EmployeeService.delete(fullName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("fullName") String fullName) {
        return EmployeeService.find(fullName);
    }

    @GetMapping("/max-salary")
    public String getEmployeeMaxSalary(@RequestParam("departmentId") int departmentId) {
        return "<h1>" + DeptService.max(departmentId) + "</h1>";
    }

    @GetMapping("/min-salary")
    public String getEmployeeMinSalary(@RequestParam("departmentId") int departmentId) {
        return "<h1>" + DeptService.min(departmentId) + "</h1>";
    }


    @GetMapping("/all")
    public String getEmployees() {
        return "<h1>" +DeptService.getAllEmployees() + "</h1>";
    }


    @GetMapping(path = "/all", params = "departmentId")
    public String getEmployeesByDept(@RequestParam("departmentId") int departmentId) {
        return "<h1>" + DeptService.getAllEmployeesByDept(departmentId) + "</h1>";
    }
}


