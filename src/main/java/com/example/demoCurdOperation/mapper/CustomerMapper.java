package com.example.demoCurdOperation.mapper;

import com.example.demoCurdOperation.dto.CustomerDTO;
import com.example.demoCurdOperation.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Primary;

@Mapper(componentModel = "spring")
@Primary
public interface CustomerMapper extends GenericMapper<Customer, CustomerDTO>{
    @Override
    @Mapping(target = "id", ignore = true)
    Customer toEntity(CustomerDTO dto);

    @Override
    CustomerDTO toDto(Customer dto);
}
