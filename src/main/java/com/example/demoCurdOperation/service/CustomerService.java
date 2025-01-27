package com.example.demoCurdOperation.service;

import com.example.demoCurdOperation.dto.CustomerDTO;
import com.example.demoCurdOperation.entity.Customer;
import com.example.demoCurdOperation.mapper.CustomerMapper;
import com.example.demoCurdOperation.repository.CustomerRepository;
import com.example.demoCurdOperation.service.serviceImpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends GenericServiceImpl<Customer, CustomerDTO> {

    public CustomerService(@Qualifier("customerRepository")CustomerRepository customerRepository,
                           @Qualifier("customerMapperImpl")CustomerMapper mapper) {
        super(customerRepository,mapper);
    }
}
