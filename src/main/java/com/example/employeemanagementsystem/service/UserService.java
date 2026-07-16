package com.example.employeemanagementsystem.service;


import com.example.employeemanagementsystem.entity.User;


public interface UserService {


    User register(User user);


    User findByUsername(String username);

}