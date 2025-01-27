package com.example.demoCurdOperation.controller;

import com.example.demoCurdOperation.dto.OrderDTO;
import com.example.demoCurdOperation.dto.OrderRequest;
import com.example.demoCurdOperation.entity.Order;
import com.example.demoCurdOperation.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderRequest orderRequest) {
        OrderDTO orderDTO = orderService.placeOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }



}
