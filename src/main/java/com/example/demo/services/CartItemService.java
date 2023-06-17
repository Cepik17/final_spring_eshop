package com.example.demo.services;

import com.example.demo.models.CartItem;
import com.example.demo.models.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CartItemService {
    void addToCart(HttpServletRequest request, Long productId, int amount);

    List<CartItem> getAllCartItems();
}
