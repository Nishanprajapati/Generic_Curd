package com.example.demoCurdOperation.controller;

import com.example.demoCurdOperation.dto.ProductDTO;
import com.example.demoCurdOperation.entity.Product;
import com.example.demoCurdOperation.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductDTO> getProductById(@PathVariable Long id){
        return productService.findById(id);
    }


    @PostMapping
     public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
     return productService.create(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        return productService.update(id, productDTO);
    }


}
