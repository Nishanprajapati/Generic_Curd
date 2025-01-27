package com.example.demoCurdOperation.mapper;

import com.example.demoCurdOperation.dto.OrderDTO;
import com.example.demoCurdOperation.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericMapper<Order, OrderDTO>{
    @Override
    @Mapping(target = "id", ignore = true)// Ignore ID during creation
    Order toEntity(OrderDTO dto);

    @Override
    OrderDTO toDto(Order entity);
}
