package com.example.demo.mappers;

import com.example.demo.dtos.ProductCreate;
import com.example.demo.dtos.ProductView;
import com.example.demo.models.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductView toView (Product product);

    List<ProductView> toViewList(List<Product> products);

    Product toEntity(ProductCreate productCreate);

    Product toEntity(ProductView ProductView);
}
