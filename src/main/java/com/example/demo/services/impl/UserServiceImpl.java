package com.example.demo.services.impl;

import com.example.demo.dtos.UserCreate;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return user;
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (User) authentication.getPrincipal();
        }
        System.out.println("userservice");
        return null;
    }

    @Override
    public String addUser(String fullName, String email, String password, String rePassword, String phoneNumber) {
        String redirectValue = "signup?errorEmail";
        User user = userRepository.findByEmail(email);
        if (user == null) {
            redirectValue = "signup?errorPassword";
            if (password.equals(rePassword)) {
                user = new User();
                user.setFullName(fullName);
                user.setEmail(email);
                user.setPassword(passwordEncoder.encode(password));
                user.setPhoneNumber(phoneNumber);
                Role role = roleRepository.getUserRole();
                List<Role> roles = List.of(role);
                user.setRoles(roles);
                userRepository.save(user);
                redirectValue = "signup?success";
            }
        }
        return redirectValue;
    }

    @Override
    public String updatePassword(String currentPassword, String newPassword, String reNewPassword) {
        User currentUser = getCurrentUser();
        String redirectValue = "profile?errorpwd";
        if (passwordEncoder.matches(currentPassword, currentUser.getPassword())) {
            redirectValue = "profile?errorpasswords";
            if (newPassword.equals(reNewPassword)) {
                currentUser.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(currentUser);
                redirectValue = "profile?success";
            }
        }
        return redirectValue;
    }

    @Override
    public String editUser(String email, Long roleId) {
        String redirectValue = "edituser?error";
        User user = userRepository.findByEmail(email);
        if (user != null) {
            List<Role> roles= roleRepository.getRolesById(roleId);
            Role role = roleRepository.getRoleById(roleId);
            System.out.println(user.getFullName() + " and "+ user.getRoles());
            user.setRoles(roles);
            userRepository.save(user);
            redirectValue = "edituser?success";
        }
        return redirectValue;
    }

    @Override
    public String deleteUser(String email) {
        String redirectValue = "edituser?errordelete";
        User user = userRepository.findByEmail(email);
        if (user != null) {
            Long id = user.getId();
            userRepository.deleteById(id);
            redirectValue = "edituser?successdelete";
        }
        return redirectValue;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
