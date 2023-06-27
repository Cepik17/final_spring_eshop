package com.example.demo.dtos;

import com.example.demo.models.CartItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartItemView {
    private Long id;
    private Long productId;
    private String productName;
    private int amount;
    private double price;
}
