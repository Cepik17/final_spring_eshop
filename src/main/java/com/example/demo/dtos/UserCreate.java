package com.example.demo.dtos;

import com.example.demo.models.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserCreate {

    private String fullName;
    private String email;
    private String password;
    private String phoneNumber;
    private List<Role> roles;
}
