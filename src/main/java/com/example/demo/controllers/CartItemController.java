package com.example.demo.controllers;

import com.example.demo.dtos.CartView;
import com.example.demo.dtos.ProductToCart;
import com.example.demo.dtos.UserView;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.*;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.ProductService;
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

    @Autowired
    private ProductService productService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;


    @PostMapping
    public CartView addToCart(@RequestBody CartRequest cartRequest) {
//        User user = userService.getEntityById(cartRequest.getUserId());
//        UserView userView = userMapper.toView(user);
//
//        Product product = productService.getEntityById(cartRequest.getProductId());
//        ProductToCart productToCart = productMapper.toCart(product);
//        System.out.println("cont");
        return cartItemService.addToCart(cartRequest, cartRequest.getAmount());
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @PostMapping("/update")
    public CartView updateCartAmount(@RequestParam(name = "cartId") Long cartId,
                                     @RequestParam(name = "itemId") Long itemId,
                                     @RequestParam(name = "newAmount") int newAmount) {
        return cartItemService.updateCartItem(cartId, itemId, newAmount);
    }

    @DeleteMapping("/delete")
    public CartView deleteCartItem(@RequestParam(name = "cartId") Long cartId,
                                   @RequestParam(name = "itemId") Long itemId){
        return cartItemService.deleteCartItem(cartId, itemId);
    }
}
