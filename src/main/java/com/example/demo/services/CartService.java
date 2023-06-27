package com.example.demo.services;

import com.example.demo.dtos.CartView;
import com.example.demo.dtos.UserView;
import com.example.demo.models.Cart;
import com.example.demo.models.CartItem;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CartService {
    Cart createCart(HttpServletRequest request);

    void addProductToCart(User user, Product product, int id);

    List<Cart> getAllCarts();

    Cart getOrCreateCart(UserView userView);

    CartView getCartByUserId(Long userId);

   // List<CartItem> getCartItems(Cart cart);
}
