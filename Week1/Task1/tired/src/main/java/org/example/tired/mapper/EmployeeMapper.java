package org.example.tired.mapper;

import org.example.tired.model.DTO.EmployeeDTO;
import org.example.tired.model.Entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO /*DTO*/mapTo(Employee/*Entity*/ a);
    Employee mapFrom(EmployeeDTO b);
}
