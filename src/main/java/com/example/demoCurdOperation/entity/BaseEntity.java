package com.example.demoCurdOperation.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
