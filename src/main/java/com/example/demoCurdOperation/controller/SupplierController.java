package com.example.demoCurdOperation.controller;

import com.example.demoCurdOperation.dto.SupplierDTO;
import com.example.demoCurdOperation.entity.Customer;
import com.example.demoCurdOperation.entity.Supplier;
import com.example.demoCurdOperation.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    private final SupplierService supplierService;
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<SupplierDTO> getAllSuppliers() {
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SupplierDTO> getSupplierById(@PathVariable Long id) {
        return supplierService.findById(id);
    }


    @PostMapping
    public SupplierDTO createSupplier(@RequestBody SupplierDTO supplierDTO) {
        return supplierService.create(supplierDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplierById(@PathVariable Long id) {
        supplierService.deleteById(id);
    }

    @PutMapping("/{id}")
    public SupplierDTO updateSupplier(@PathVariable Long id,@RequestBody SupplierDTO supplierDTO) {
        return supplierService.update(id,supplierDTO);
    }

}
