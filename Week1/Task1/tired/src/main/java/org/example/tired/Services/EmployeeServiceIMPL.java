package org.example.tired.Services;
import org.example.tired.mappers.Mapper;
import org.example.tired.model.DTO.EmployeeDTO;
import org.example.tired.model.Entities.Employee;
import org.example.tired.model.Repository.EmployeeRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Primary
public class EmployeeServiceIMPL implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Mapper<Employee, EmployeeDTO> employeeMapper;
    public EmployeeServiceIMPL(EmployeeRepository employeeRepository, Mapper<Employee, EmployeeDTO> employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll(); // Assuming employeeRepository is a JPA repository
        return employees.stream()
                .map(employee -> new EmployeeDTO(employee.getId(), employee.getName(), employee.getDepartment(), employee.getSalary()))
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Integer id) {
        return employeeMapper.mapTo(employeeRepository.findById(id).orElse(null));
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.mapTo(employeeRepository.save(employeeMapper.mapFrom(employeeDTO)));
    }
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        return employeeMapper.mapTo(employeeRepository.save(employeeMapper.mapFrom(employeeDTO)));
    }
}
