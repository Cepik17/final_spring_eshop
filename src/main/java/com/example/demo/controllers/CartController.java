package com.example.demo.controllers;

import com.example.demo.dtos.UserView;
import com.example.demo.models.Cart;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Cart createCart(@RequestBody UserView userView){
        return cartService.getOrCreateCart(userView);

       // cartItemService.addToCart(userId,productId,amount);
    }

    @GetMapping
    public List<Cart> getAllCarts(){
        return cartService.getAllCarts();
    }

}
