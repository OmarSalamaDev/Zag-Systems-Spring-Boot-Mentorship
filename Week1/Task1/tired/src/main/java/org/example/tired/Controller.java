package org.example.tired;

import org.example.tired.IMPL.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class Controller {
    private final EmployeeService employeeService;
    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PostMapping("/api/employees")
    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }
}