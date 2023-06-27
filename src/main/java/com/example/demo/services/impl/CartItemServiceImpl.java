package com.example.demo.services.impl;

import com.example.demo.dtos.CartView;
import com.example.demo.dtos.ProductToCart;
import com.example.demo.dtos.ProductView;
import com.example.demo.dtos.UserView;
import com.example.demo.mappers.CartItemMapper;
import com.example.demo.mappers.CartMapper;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.*;
import com.example.demo.repositories.CartItemRepository;
import com.example.demo.repositories.CartRepository;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartItemMapper cartItemMapper;

    @Override
    public CartView addToCart(CartRequest cartRequest, int amount) {
        User user = userService.getEntityById(cartRequest.getUserId());
        UserView userView = userMapper.toView(user);
        Product product = productService.getEntityById(cartRequest.getProductId());
        ProductToCart productToCart = productMapper.toCart(product);
        System.out.println("cartitemservice");
        Cart cart = cartService.getOrCreateCart(userView);
        CartItem cartItem = findCartItem(cart, productToCart);
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setPrice(product.getPrice());
            //cartItemRepository.save(cartItem);
            cart.getCartItems().add(cartItem);
        }
        cartItem.setAmount(cartItem.getAmount() + amount);
        cartItemRepository.save(cartItem);
        cart.setTotalCost(cart.getTotalCost());
        cartRepository.save(cart);
        return cartMapper.toView(cart);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem findCartItem(Cart cart, ProductToCart productToCart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(productToCart.getId())) {
                return item;
            }
        }
        return null;
    }

    @Override
    public CartView updateCartItem(Long cartId, Long itemId, int newAmount) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        CartItem cartItem = cartItemRepository.findById(itemId).orElseThrow();
        cartItem.setAmount(newAmount);
        cartItemRepository.save(cartItem);
        cart.setTotalCost(cart.getTotalCost());
        //Cart updatedCart = cartRepository.save(cart);
        cartRepository.save(cart);
        return cartMapper.toView(cart);
    }

    @Override
    public CartView deleteCartItem(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        CartItem cartItem = cartItemRepository.findById(itemId).orElseThrow();
        cart.getCartItems().remove(cartItem);
        cartRepository.save(cart);
        cartItemRepository.delete(cartItem);
        return cartMapper.toView(cart);
    }
}
