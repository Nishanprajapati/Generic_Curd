package com.example.demoCurdOperation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name ="customer")
public class Customer extends BaseEntity {
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer",cascade= CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders;
}
