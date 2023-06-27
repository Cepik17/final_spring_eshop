package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Getter
@Setter
public class CartView {

    private Long id;
    private Long userId;
    private List<CartItemView> cartItems;
    private double totalCost;

}


