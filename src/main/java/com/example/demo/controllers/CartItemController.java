package com.example.demo.controllers;

import com.example.demo.models.Cart;
import com.example.demo.models.CartItem;
import com.example.demo.models.User;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


    @PostMapping
    public void addToCart(@RequestParam (name= "email") String email,
                          @RequestParam (name= "productId") Long productId,
                          @RequestParam (name= "amount") int amount){
        System.out.println("cont");
        cartItemService.addToCart(email, productId, amount);
    }

    @GetMapping
    public List<CartItem> getAllCartItems(){
        return cartItemService.getAllCartItems();
    }
}
