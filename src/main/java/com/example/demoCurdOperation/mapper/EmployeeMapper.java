package com.example.demoCurdOperation.mapper;

import com.example.demoCurdOperation.dto.EmployeeDTO;
import com.example.demoCurdOperation.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeDTO dto);

    EmployeeDTO toDto(Employee entity);
}
