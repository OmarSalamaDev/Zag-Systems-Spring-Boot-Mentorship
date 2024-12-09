package org.example.tired.Services;

import org.example.tired.model.DTO.EmployeeDTO;
import org.example.tired.model.Entities.Employee;

public interface EmployeeService {
    public Iterable<EmployeeDTO> getAllEmployees();
    public EmployeeDTO getEmployeeById(Integer id);
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    public void deleteEmployee(Integer id);
}
