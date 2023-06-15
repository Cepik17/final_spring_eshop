package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="comments")
@Getter
@Setter

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String post;
    private LocalDateTime postTime;
    @ManyToOne
    private Product product;
    @ManyToOne
    private User author;

}
