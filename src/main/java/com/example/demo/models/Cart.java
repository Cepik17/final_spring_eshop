package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.service.spi.InjectService;

import java.util.List;

@Entity
@Table(name="carts")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;
}
