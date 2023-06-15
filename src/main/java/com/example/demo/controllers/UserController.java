package com.example.demo.controllers;

import com.example.demo.dtos.UserCreate;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/signin")
    public String signInPage(){
        return "signin";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String profilePage(Model model){
        User user =userService.getCurrentUser();
        model.addAttribute("currentUser", user);
        return "profile";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/signup")
    public String signUpPage(){
        return "signup";
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/signup")
    public String registerPage(@RequestParam String fullName,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String rePassword,
                               @RequestParam String phoneNumber){
        String value = userService.addUser(fullName, email, password, rePassword, phoneNumber);
        return "redirect:/" + value;
    }

    @GetMapping("/forbidden")
    public String forbidden(){
        return "403";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/updatepassword")
    public String updatePwd(@RequestParam (name="current_password") String currentPassword,
                            @RequestParam (name="new_password") String newPassword,
                            @RequestParam (name="re_new_password") String reNewPassword){
        String value = userService.updatePassword(currentPassword, newPassword, reNewPassword);
        return "redirect:/" + value;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/edituser")
    public String userPage(){
        return "edituser";
    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/edituser")
    public String editUser(@RequestParam String email,
                         @RequestParam Long roleId){
        String value = userService.editUser(email,roleId);
        return "redirect:/"+value;

    }

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping("/deleteuser")
    public String deleteUser(@RequestParam String email){
        String value = userService.deleteUser(email);
        return "redirect:/"+value;

    }
}
