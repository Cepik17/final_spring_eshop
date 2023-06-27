package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderView {
    private Long id;
    private UserView userView;
    private CartView cartView;
    private double totalCost;
}
