package com.example.demoCurdOperation.mapper;

import com.example.demoCurdOperation.dto.ProductDTO;
import com.example.demoCurdOperation.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {
    @Override
    @Mapping(target = "id", ignore = true) // Ignore ID during creation
    Product toEntity(ProductDTO dto);

    @Override
    ProductDTO toDto(Product entity);
}
