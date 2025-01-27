package com.example.demoCurdOperation.service.serviceImpl;

import com.example.demoCurdOperation.entity.BaseEntity;
import com.example.demoCurdOperation.mapper.GenericMapper;
import com.example.demoCurdOperation.repository.GenericRepository;
import com.example.demoCurdOperation.service.GenericService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenericServiceImpl <T extends BaseEntity,D> implements GenericService<T,D> {


    private final GenericRepository<T> repository;
    private final GenericMapper<T , D>  mapper ;
    public GenericServiceImpl(GenericRepository<T> repository,
                              @Qualifier("customerMapperImpl")GenericMapper<T, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<D> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<D> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }


    public D create(D dto) {
        T entity = mapper.toEntity(dto);
        T savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public D update(Long id, D dto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entity with ID " + id + " not found.");
        }
        T entity = mapper.toEntity(dto);
        entity.setId(id);
        T updatedEntity = repository.save(entity);
        return mapper.toDto(updatedEntity);
    }
}
