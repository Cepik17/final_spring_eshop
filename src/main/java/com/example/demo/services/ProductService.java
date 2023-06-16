package com.example.demo.services;

import com.example.demo.dtos.ProductCreate;
import com.example.demo.dtos.ProductView;
import com.example.demo.dtos.SpecsCreate;

import java.util.List;

public interface ProductService {
    List<ProductView> getAllProducts();

    ProductView getProductById(Long id);

    ProductView createProduct(ProductCreate productCreate, SpecsCreate specsCreate);
}
