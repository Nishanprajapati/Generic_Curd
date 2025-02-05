package com.example.demoCurdOperation.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;


@MapperConfig
public interface GenericMapper <E,D>{
    D toDto(E entity);
    E toEntity(D dto);
    void updateEntityFromDto(D dto, @MappingTarget E entity);
}
