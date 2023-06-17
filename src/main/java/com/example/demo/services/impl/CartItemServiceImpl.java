package com.example.demo.services.impl;

import com.example.demo.dtos.ProductView;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.Cart;
import com.example.demo.models.CartItem;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.repositories.CartItemRepository;
import com.example.demo.repositories.CartRepository;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;

//    @Override
//    public void addToCart(Long userId, Long productId, int amount) {
//        Cart cart = cartService.getOrCreateCart(userId);
//        ProductView productView = productService.getProductById(productId);
//        Product product = productMapper.toEntity(productView);
//        CartItem cartItem = new CartItem();
//        cartItem.setCart(cart);
//        cartItem.setProduct(product);
//        cartItem.setAmount(amount);
//        //cart.getCartItems().add(cartItem);
//        cart.setCartItems(List.of(cartItem));
//        cartRepository.save(cart);
//    }
    @Override
    public void addToCart(HttpServletRequest request, Long productId, int amount) {
        System.out.println("service");

        ProductView productView = productService.getProductById(productId);
        Product product = productMapper.toEntity(productView);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setAmount(amount);
        Cart cart = cartService.createCart(request);
       // cart.getCartItems().add(cartItem);
        cart.setCartItems(List.of(cartItem));
        cartRepository.save(cart);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
}
