package com.example.demo.dtos;

import com.example.demo.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserView {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
}
