package com.example.demo.controllers;

import com.example.demo.models.Cart;
import com.example.demo.models.CartItem;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @PutMapping
    public void addToCart(HttpServletRequest request,
                          @RequestParam(name="productId") Long productId,
                          @RequestParam int amount){
        System.out.println("cont");
        cartItemService.addToCart(request,productId,amount);
    }

    @GetMapping
    public List<CartItem> getAllCartItems(){
        return cartItemService.getAllCartItems();
    }
}
