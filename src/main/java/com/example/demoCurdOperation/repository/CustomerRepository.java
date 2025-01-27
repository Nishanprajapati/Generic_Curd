package com.example.demoCurdOperation.repository;

import com.example.demoCurdOperation.entity.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface CustomerRepository extends GenericRepository<Customer> {
}
