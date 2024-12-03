package org.example.tired;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
}
