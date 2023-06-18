package com.example.demo.services;

import com.example.demo.models.Cart;
import com.example.demo.models.CartItem;
import com.example.demo.models.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CartItemService {

    void addToCart(String email, Long productId, int amount);

    List<CartItem> getAllCartItems();

    CartItem findCartItem(Cart cart, Long productId);
}
