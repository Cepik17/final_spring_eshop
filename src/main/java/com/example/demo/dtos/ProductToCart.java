package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductToCart {
    private Long id;
    private String name;
    private double price;
}
