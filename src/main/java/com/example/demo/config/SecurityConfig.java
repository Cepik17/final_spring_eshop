package com.example.demo.config;

import com.example.demo.services.UserService;
import com.example.demo.services.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService()).passwordEncoder(passwordEncoder());

        http.exceptionHandling().accessDeniedPage("/forbidden");

        http.formLogin()
                .loginPage("/signin") // страница авторизации
                .usernameParameter("user_email")
                .passwordParameter("user_password")
                .loginProcessingUrl("/enter") // где происходит проверка
                .defaultSuccessUrl("/")
                .failureUrl("/signin?error");

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
        http.csrf().disable();
        return http.build();
    }
}
