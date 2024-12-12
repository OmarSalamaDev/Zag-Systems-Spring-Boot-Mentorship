package org.example.tired.service;

import org.example.tired.model.DTO.EmployeeDTO;

public interface EmployeeService {
    public Iterable<EmployeeDTO> getAllEmployees();
    public EmployeeDTO getEmployeeById(Integer id);
    public void saveEmployee(EmployeeDTO employeeDTO);
    public void updateEmployee(EmployeeDTO employeeDTO);
    public void deleteEmployee(Integer id);
}
