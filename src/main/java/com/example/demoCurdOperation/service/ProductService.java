package com.example.demoCurdOperation.service;

import com.example.demoCurdOperation.dto.ProductDTO;
import com.example.demoCurdOperation.entity.Product;
import com.example.demoCurdOperation.mapper.ProductMapper;
import com.example.demoCurdOperation.repository.ProductRepository;
import com.example.demoCurdOperation.service.serviceImpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericServiceImpl<Product, ProductDTO> {

    public ProductService(@Qualifier("productRepository")ProductRepository repository,
                          @Qualifier("productMapperImpl") ProductMapper mapper) {
        super(repository,mapper);
    }
}
