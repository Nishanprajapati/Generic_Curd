package com.example.demoCurdOperation.controller;

import com.example.demoCurdOperation.dto.CustomerDTO;
import com.example.demoCurdOperation.entity.Customer;
import com.example.demoCurdOperation.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return customerService.findById(id);
    }

     @PostMapping
     public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
      return customerService.create(customerDTO);
      }



    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.update(id, customerDTO);
    }

}
