package com.example.demo.mappers;

import com.example.demo.dtos.CartItemView;
import com.example.demo.models.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemMapper {
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    List<CartItemView> toViewList(List<CartItem> cartItems);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "productName", target = "product.name")
    List<CartItem> toEntityList(List<CartItemView> cartItemViews);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    CartItemView toView(CartItem cartItem);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "productName", target = "product.name")
    CartItem toEntity(CartItemView cartItemView);
}
