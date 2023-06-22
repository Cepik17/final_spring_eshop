package com.example.demo.services;

import com.example.demo.dtos.ProductToCart;
import com.example.demo.dtos.UserView;
import com.example.demo.models.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CartItemService {

    Cart addToCart(CartRequest cartRequest, int amount);

    List<CartItem> getAllCartItems();

    CartItem findCartItem(Cart cart, ProductToCart productToCart);
}
