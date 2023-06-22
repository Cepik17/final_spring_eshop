package com.example.demo.services;

import com.example.demo.dtos.ProductCreate;
import com.example.demo.dtos.ProductView;
import com.example.demo.dtos.SpecsCreate;
import com.example.demo.models.Product;

import java.util.List;

public interface ProductService {
    List<ProductView> getAllProducts();

    List<ProductView> getAllHotDeals();

    ProductView getProductById(Long id);

    ProductView createProduct(ProductCreate productCreate, SpecsCreate specsCreate);

    Product getEntityById(Long id);
}
