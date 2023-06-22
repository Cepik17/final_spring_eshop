package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequest {
    private Long userId;
    private Long productId;
    private Integer amount;
}
