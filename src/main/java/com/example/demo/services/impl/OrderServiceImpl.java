package com.example.demo.services.impl;

import com.example.demo.dtos.CartItemView;
import com.example.demo.dtos.CartView;
import com.example.demo.dtos.OrderView;
import com.example.demo.enums.OrderStatus;
import com.example.demo.mappers.CartItemMapper;
import com.example.demo.mappers.CartMapper;
import com.example.demo.mappers.OrderMapper;
import com.example.demo.models.CartItem;
import com.example.demo.models.Order;
import com.example.demo.models.Cart;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.CartService;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CartItemMapper cartItemMapper;

    @Override
    public Order createOrder(Long userId) {
        CartView cartView = cartService.getCartByUserId(userId);
        Cart cart= cartMapper.toEntity(cartView);
//        List<CartItem> cartItems = cartService.
        Order newOrder = new Order();
        newOrder.setUser(userService.getUserById(userId));
        newOrder.setCart(cart);
        newOrder.setStatus(OrderStatus.NEW);
        orderRepository.save(newOrder);
        return newOrder;
    }
}
