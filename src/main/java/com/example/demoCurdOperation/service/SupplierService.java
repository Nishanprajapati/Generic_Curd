package com.example.demoCurdOperation.service;

import com.example.demoCurdOperation.dto.SupplierDTO;
import com.example.demoCurdOperation.entity.Supplier;
import com.example.demoCurdOperation.mapper.SupplierMapper;
import com.example.demoCurdOperation.repository.SupplierRepository;
import com.example.demoCurdOperation.service.serviceImpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SupplierService extends GenericServiceImpl<Supplier, SupplierDTO> {
    public SupplierService(@Qualifier("supplierRepository")SupplierRepository repository,
                           @Qualifier("supplierMapperImpl")SupplierMapper mapper) {
        super(repository,mapper);
    }
}
