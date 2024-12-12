package org.example.tired;

import org.example.tired.service.EmployeeService;
import org.example.tired.model.DTO.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") //> permits this domain to access the api
@RestController //> indicates that this controller will handle HTTP requests and send responses in json
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //> get all the employees
    @GetMapping("/api/employees")
    public ResponseEntity<Iterable<EmployeeDTO>> getAllEmployees() {
        Iterable<EmployeeDTO> employeeDTOS =  employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDTOS);
    }

    //> add a new employee
    @PostMapping("/api/employees")
    public void addEmployee(@RequestBody EmployeeDTO employee) {
        if(employee.getName().isEmpty() || employee.getDepartment().isEmpty() || employee.getSalary() <= 0) {
            return;
        }
        employeeService.saveEmployee(employee);
    }

    //> delete an employee by its id
    @DeleteMapping("/api/employees/{id}")
    public void removeEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

    //> update un employee
    @PutMapping("/api/employees")
    public void updateEmployee(@RequestBody EmployeeDTO employee) {
        if(employee.getName().isEmpty() || employee.getDepartment().isEmpty() || employee.getSalary() <= 0) {
            return;
        }
        employeeService.updateEmployee(employee);
    }
}
