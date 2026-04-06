package com.coditas.ecommerceordermanagementsystem.service;

import com.coditas.ecommerceordermanagementsystem.entity.User;
import com.coditas.ecommerceordermanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public String loginUser(@RequestBody User existingUser){

        String password = existingUser.getPassword();
        String existingusername = existingUser.getUsername();

        User user = userRepository.findByUsername(existingusername);

        if(user.getPassword() != password){
            new RuntimeException("You are not a valid user! ");
        }
        return "Logged In";
    }
}
