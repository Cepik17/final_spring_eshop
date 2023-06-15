package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecsCreate {
    private double display;
    private String processor;
    private String ram;
    private String memory;
    private String video;
    private String os;
}
