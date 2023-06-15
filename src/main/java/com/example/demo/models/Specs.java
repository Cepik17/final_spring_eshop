package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="specs")
@Getter
@Setter
public class Specs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double display;
    private String processor;
    private String ram;
    private String memory;
    private String video;
    private String os;

}
