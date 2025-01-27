package com.example.demoCurdOperation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private Long customerId;
    private Long productId;
    private int quantity;
}
