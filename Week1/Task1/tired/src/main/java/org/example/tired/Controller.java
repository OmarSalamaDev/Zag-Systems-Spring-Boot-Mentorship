package org.example.tired;

import org.example.tired.FrontEndLayer.IMPL.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class Controller {
    private final EmployeeService employeeService;
    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }
}
