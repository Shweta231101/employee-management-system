package com.example.employeemanagementsystem.dataloader;


import com.example.employeemanagementsystem.entity.User;
import com.example.employeemanagementsystem.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public DataLoader(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public void run(String... args) {


        if(userRepository.findByUsername("admin").isEmpty()) {


            User user = new User();

            user.setUsername("admin");

            user.setPassword(
                    passwordEncoder.encode("admin123")
            );


            userRepository.save(user);


            System.out.println("Default user created");
        }

    }
}