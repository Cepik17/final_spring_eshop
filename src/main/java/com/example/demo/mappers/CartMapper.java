package com.example.demo.mappers;

import com.example.demo.dtos.CartView;
import com.example.demo.models.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CartItemMapper.class)
public interface CartMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "cartItems", target = "cartItems")
    @Mapping(expression = "java(cart.getTotalCost())", target = "totalCost")
    CartView toView(Cart cart);

    @Mapping(source = "userId", target = "user.id")
    Cart toEntity(CartView cartView);
}
