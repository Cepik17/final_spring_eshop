package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int amount;
    private String brand;
    private String category;
    private double rating;
    private boolean isHotDeal;
//    @ManyToOne
//    private Cart cart;
    @OneToOne
    private Specs specs;

}
