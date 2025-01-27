package com.example.demoCurdOperation.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="supplier")
public class Supplier extends BaseEntity {

    private String supplierName;
    private String phoneNumber;
    private String address;
}
