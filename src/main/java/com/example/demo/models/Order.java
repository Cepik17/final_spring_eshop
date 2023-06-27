package com.example.demo.models;

import com.example.demo.dtos.CartView;
import com.example.demo.enums.OrderStatus;
import com.example.demo.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private Cart cart;
    @Enumerated (EnumType.STRING)
    private OrderStatus status;

}
