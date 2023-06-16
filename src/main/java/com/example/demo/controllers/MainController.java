package com.example.demo.controllers;

import com.example.demo.dtos.ProductView;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/products")
    public String productPage(){
        return "products";
    }

    @GetMapping("/productdetails/{id}")
    public String productDetailPage(@PathVariable Long id, Model model){
        ProductView productView = productService.getProductById(id);
        model.addAttribute("product",productView);
        return "productdetails";
    }

}
