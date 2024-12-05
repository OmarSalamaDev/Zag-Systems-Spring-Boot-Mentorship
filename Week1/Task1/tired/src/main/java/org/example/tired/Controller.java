package org.example.tired;

import org.example.tired.IMPL.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342/") //> permits this domain to access the api
@RestController //> indicates that this controller will handle HTTP requests and send responses in json
public class Controller {

    private final EmployeeService employeeService;

    public Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //> get all the employees
    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //> add a new employee
    @PostMapping("/api/employees")
    public void addEmployee(@RequestBody Employee employee) {
        if(employee.getName().isEmpty() || employee.getDepartment().isEmpty() || employee.getSalary() <= 0) {
            return;
        }
        employeeService.addEmployee(employee);
    }

    //> delete an employee by its id
    @DeleteMapping("/api/employees/{id}")
    public void removeEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
    }

    //> update un employee
    @PutMapping("/api/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        if(employee.getName().isEmpty() || employee.getDepartment().isEmpty() || employee.getSalary() <= 0) {
            return;
        }
        employeeService.updateEmployee(employee);
    }
}
