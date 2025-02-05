package com.example.demoCurdOperation.service;

import com.example.demoCurdOperation.dto.EmployeeDTO;
import com.example.demoCurdOperation.entity.Employee;
import com.example.demoCurdOperation.mapper.EmployeeMapper;
import com.example.demoCurdOperation.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, BCryptPasswordEncoder passwordEncoder, ObjectMapper objectMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.passwordEncoder = passwordEncoder;
        this.objectMapper = objectMapper;
    }





    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        employeeDTO.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));

        try {
            String methDataJson = employeeDTO.getMetaData();
            Object methDataObject = objectMapper.readValue(methDataJson, Object.class);
            employeeDTO.setMetaData(objectMapper.writeValueAsString(methDataObject));
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while processing metaData", e);
        }
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    
    public EmployeeDTO getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + id));
        EmployeeDTO employeeDTO = employeeMapper.toDto(employee);
        try {
            if (employeeDTO.getMetaData() != null) {
                Object methDataObject = objectMapper.readValue(employeeDTO.getMetaData(), Object.class);
                employeeDTO.setMetaData(objectMapper.writeValueAsString(methDataObject));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while processing methData", e);
        }

        return employeeDTO;
    }



}
