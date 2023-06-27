package com.example.demo.services;

import com.example.demo.dtos.OrderView;
import com.example.demo.models.Order;

public interface OrderService {
    Order createOrder(Long userId);
}
