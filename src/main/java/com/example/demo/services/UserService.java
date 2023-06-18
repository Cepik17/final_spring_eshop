package com.example.demo.services;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User getCurrentUser();

    String addUser(String fullName, String email, String password, String rePassword,
                   String phoneNumber);

    String updatePassword(String currentPassword, String newPassword, String reNewPassword);
    String editUser(String email, Long roleId);

    String deleteUser(String email);

    User getUserById(Long id);

    User getUserByEmail(String email);
}
