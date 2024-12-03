package org.example.tired.FrontEndLayer.IMPL;

import org.example.tired.Employee;
import org.example.tired.EmployeeDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeDAO employeeDAO;
    EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }
}
