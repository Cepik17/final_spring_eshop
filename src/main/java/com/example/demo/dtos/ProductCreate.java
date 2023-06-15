package com.example.demo.dtos;

import com.example.demo.models.Specs;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCreate {

    private String name;
    private double price;
    private int amount;
    private String brand;
    private String category;
    private boolean isHotDeal;
    private SpecsCreate specs;
}
