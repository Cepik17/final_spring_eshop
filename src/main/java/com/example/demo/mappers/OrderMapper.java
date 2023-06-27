package com.example.demo.mappers;

import com.example.demo.dtos.OrderView;
import com.example.demo.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "user", target = "userView")
    @Mapping(source = "cart", target = "cartView")
    @Mapping(source = "cart.totalCost", target = "totalCost")
    OrderView toView(Order order);

    @Mapping(source = "userView", target = "user")
    @Mapping(source = "cartView", target = "cart")
    @Mapping(source = "totalCost", target = "cart.totalCost")
    Order toEntity(OrderView orderView);
}
