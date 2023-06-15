package com.example.demo.models;

import com.example.demo.enums.OrderStatus;
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
    @ManyToOne
    private User user;
    private double sum;
    private String address;
    @Enumerated (EnumType.STRING)
    private OrderStatus status;

}
