package com.example.demo.dtos;

import com.example.demo.models.Specs;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductView {

    private String name;
    private double price;
    private String brand;
    private String category;
    private boolean isHotDeal;
    private SpecsView specs;
}
