package com.example.employeemanagementsystem.controller;


import com.example.employeemanagementsystem.entity.User;
import com.example.employeemanagementsystem.service.UserService;
import com.example.employeemanagementsystem.security.JwtUtil;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthenticationManager authenticationManager;

    private final UserService userService;


    public AuthController(
            AuthenticationManager authenticationManager,
            UserService userService
    ){
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }



    @PostMapping("/register")
    public User register(
            @RequestBody User user
    ){

        return userService.register(user);

    }



    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request
    ){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );


        return JwtUtil.generateToken(
                request.username()
        );

    }



    public record LoginRequest(
            String username,
            String password
    ){}

}