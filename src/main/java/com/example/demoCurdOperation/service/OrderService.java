package com.example.demoCurdOperation.service;

import com.example.demoCurdOperation.dto.OrderDTO;
import com.example.demoCurdOperation.dto.OrderRequest;
import com.example.demoCurdOperation.entity.Customer;
import com.example.demoCurdOperation.entity.Order;
import com.example.demoCurdOperation.entity.Product;
import com.example.demoCurdOperation.mapper.OrderMapper;
import com.example.demoCurdOperation.repository.CustomerRepository;
import com.example.demoCurdOperation.repository.OrderRepository;
import com.example.demoCurdOperation.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService{

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }



    public OrderDTO placeOrder(OrderRequest orderRequest) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerId(orderRequest.getCustomerId());
        orderDTO.setProductId(orderRequest.getProductId());
        orderDTO.setQuantity(orderRequest.getQuantity());

        Order order = orderMapper.toEntity(orderDTO);
        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + orderRequest.getCustomerId()));

        Product product = productRepository.findById(orderRequest.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + orderRequest.getProductId()));

        order.setCustomer(customer);
        order.setProduct(product);
        order.setOrderDate(LocalDate.now());

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

}
