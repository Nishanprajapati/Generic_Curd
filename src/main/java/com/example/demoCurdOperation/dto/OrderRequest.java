package com.example.demoCurdOperation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Long customerId;
    private Long ProductId;
    private int quantity;
}
