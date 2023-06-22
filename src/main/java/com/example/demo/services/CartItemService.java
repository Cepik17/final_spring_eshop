package com.example.demo.services;

import com.example.demo.dtos.ProductToCart;
import com.example.demo.dtos.UserView;
import com.example.demo.models.Cart;
import com.example.demo.models.CartItem;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CartItemService {

    Cart addToCart(UserView userView, ProductToCart productToCart, int amount);

    List<CartItem> getAllCartItems();

    CartItem findCartItem(Cart cart, ProductToCart productToCart);
}
