package com.example.demo.controllers;

import com.example.demo.dtos.ProductView;
import com.example.demo.models.User;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String mainPage(Model model){
//        List<ProductView> productViewList = productService.getAllHotDeals();
//        model.addAttribute("hotproducts",productViewList);
        User user =userService.getCurrentUser();
        Long userId= user.getId();
        model.addAttribute("userId", userId);
        return "index";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/products")
    public String productPage(Model model){
        User user =userService.getCurrentUser();
        model.addAttribute("currentUser", user);
        return "products";
    }

    @GetMapping("/productdetails/{id}")
    public String productDetailPage(@PathVariable Long id, Model model){
        ProductView productView = productService.getProductById(id);
        //System.out.println("contoler:" + productView.isHotDeal());
        model.addAttribute("product",productView);
        return "productdetails";
    }

}
