package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Table(name="cart_items")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int amount;
    private double totalPrice;

    public void setAmount(int amount) {
        this.amount = amount;
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        totalPrice = product.getPrice() * amount;
    }

}
