package com.example.demo.services.impl;

import com.example.demo.dtos.UserView;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.Cart;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.repositories.CartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.CartService;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserMapper userMapper;

//    @Override
//    public Cart createCart(User user, List<Product> products) {
//        Cart newCart = new Cart();
//        newCart.setUser(user);
//        // newCart.setProducts(products);
//        cartRepository.save(newCart);
//        return newCart;
//    }

    @Override
    public Cart createCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            cart.setCartItems(new ArrayList<>());
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @Override
    public void addProductToCart(User user, Product product, int id) {

    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

//    @Override
//    public Cart getOrCreateCart(Long userId) {
//        User user = userService.getUserById(userId);
//        if (user == null) {
//            HttpSession session = request.getSession();
//            Cart cart = (Cart) session.getAttribute("cart");
//            if (cart == null) {
//                cart = new Cart();
//                //cart.setUser(null);
//                cart.setCartItems(new ArrayList<>());
//                session.setAttribute("cart", cart);
//            }
//            return cart;
//        }
//        Cart cart = cartRepository.findByUser(user);
//        if (cart == null) {
//            cart = new Cart();
//          //  cart.setUser(user);
//            cart.setCartItems(new ArrayList<>());
//            cartRepository.save(cart);
//
//        }
//        return cart;
//    }

    @Override
    public Cart getOrCreateCart(UserView userView) {
        System.out.println("cartservice");
//        Cart cart;
//        if (user != null) {
//            cart = cartRepository.findByUser(user);
//            if (cart == null) {
//                cart = new Cart();
//                cart.setUser(user);
//                cart.setCartItems(new ArrayList<>());
//                cart = cartRepository.save(cart);
//            }
//        } else {
//            HttpSession session = request.getSession();
//            cart = (Cart) session.getAttribute("cart");
//            if (cart == null) {
//                cart = new Cart();
//                cart.setCartItems(new ArrayList<>());
//                session.setAttribute("cart", cart);
//            }
//        }
//        return cart;
        User user = userMapper.toEntity(userView);

        Cart cart = cartRepository.findByUser(user);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setCartItems(new ArrayList<>());
            cart = cartRepository.save(cart);
        }
        return cart;
    }
}
