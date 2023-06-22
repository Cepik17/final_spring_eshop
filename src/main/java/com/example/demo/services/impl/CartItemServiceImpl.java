package com.example.demo.services.impl;

import com.example.demo.dtos.ProductToCart;
import com.example.demo.dtos.ProductView;
import com.example.demo.dtos.UserView;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.Cart;
import com.example.demo.models.CartItem;
import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.repositories.CartItemRepository;
import com.example.demo.repositories.CartRepository;
import com.example.demo.services.CartItemService;
import com.example.demo.services.CartService;
import com.example.demo.services.ProductService;
import com.example.demo.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;

//    @Override
//    public void addToCart(Long userId, Long productId, int amount) {
//        Cart cart = cartService.getOrCreateCart(userId);
//        ProductView productView = productService.getProductById(productId);
//        Product product = productMapper.toEntity(productView);
//        CartItem cartItem = new CartItem();
//        cartItem.setCart(cart);
//        cartItem.setProduct(product);
//        cartItem.setAmount(amount);
//        //cart.getCartItems().add(cartItem);
//        cart.setCartItems(List.of(cartItem));
//        cartRepository.save(cart);
//    }
    @Override
    public Cart addToCart(UserView userView, ProductToCart productToCart, int amount) {
        System.out.println("cartitemservice");
        Cart cart = cartService.getOrCreateCart(userView);

//        ProductView productView = productService.getProductById(productId);
//        Product product = productMapper.toEntity(productView);
//
//        CartItem cartItem = new CartItem();
//        cartItem.setProduct(product);
//        cartItem.setAmount(amount);
//        Cart cart = cartService.createCart(request);
//       // cart.getCartItems().add(cartItem);
//        cart.setCartItems(List.of(cartItem));
//        cartRepository.save(cart);
        CartItem cartItem = findCartItem(cart, productToCart);
        if (cartItem == null) {
            cartItem = new CartItem();
           // ProductView productView = productService.getProductById(productId);
           //Product product = productMapper.toEntity(productToCart);
            //ProductView productView = productService.getProductById(productToCart.getId());
            Long productId = productToCart.getId();
            String productname= productToCart.getName();
            System.out.println("productId = " + productId + "and name" + productname);
            Product product = productService.getEntityById(productId);
            cartItem.setProduct(product);
            cartItemRepository.save(cartItem);
            cart.getCartItems().add(cartItem);
        }
        cartItem.setAmount(cartItem.getAmount() + amount);
        cartItemRepository.save(cartItem);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem findCartItem(Cart cart, ProductToCart productToCart) {
        // Получаем список всех товаров в корзине
        List<CartItem> cartItems = cart.getCartItems();

        // Проходим по каждому товару в корзине
        for (CartItem item : cartItems) {
            // Если ID продукта в текущем товаре совпадает с искомым productId
            if (item.getProduct().getId().equals(productToCart.getId())) {
                // Возвращаем этот товар
                return item;
            }
        }

        // Если после прохода по всем товарам ничего не найдено, возвращаем null
        return null;
    }
}
