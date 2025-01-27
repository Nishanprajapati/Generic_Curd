package com.example.demoCurdOperation.mapper;

import com.example.demoCurdOperation.dto.SupplierDTO;
import com.example.demoCurdOperation.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends GenericMapper<Supplier, SupplierDTO> {
    @Override
    @Mapping(target = "id", ignore = true) // Ignore ID during creation
    Supplier toEntity(SupplierDTO dto);

    @Override
    SupplierDTO toDto(Supplier entity);
}
