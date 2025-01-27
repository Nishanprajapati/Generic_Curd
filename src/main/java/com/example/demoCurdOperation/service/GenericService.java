package com.example.demoCurdOperation.service;

import com.example.demoCurdOperation.entity.BaseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GenericService <T extends BaseEntity,D>{
    List<D> findAll();
    Optional<D> findById(Long id);
     D create(D dto);
    void deleteById(Long id);
    D update(Long id, D dto);
}
