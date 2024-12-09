package org.example.tired.mappers.IMPL;

import org.example.tired.mappers.Mapper;
import org.example.tired.model.DTO.EmployeeDTO;
import org.example.tired.model.Entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperIMPL implements Mapper<Employee, EmployeeDTO> {
    private final ModelMapper modelMapper;
    public EmployeeMapperIMPL(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public EmployeeDTO mapTo(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
    @Override
    public Employee mapFrom(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }

}
// persistence (Repo, entity) ==> service(services) ==> presentation layer (controller)