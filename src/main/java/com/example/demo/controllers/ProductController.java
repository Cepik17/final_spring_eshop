package com.example.demo.controllers;

import com.example.demo.dtos.ProductCreate;
import com.example.demo.dtos.ProductView;
import com.example.demo.dtos.SpecsCreate;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductView> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public ProductView getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductView createProduct (@RequestBody ProductCreate productCreate,
                                      SpecsCreate specsCreate){
        return productService.createProduct(productCreate, specsCreate);

    }
}
