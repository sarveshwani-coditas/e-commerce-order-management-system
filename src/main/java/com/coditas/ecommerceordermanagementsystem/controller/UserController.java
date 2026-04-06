package com.coditas.ecommerceordermanagementsystem.controller;

import com.coditas.ecommerceordermanagementsystem.entity.User;
import com.coditas.ecommerceordermanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PutMapping("/login")
    public String userLogin(@RequestBody User user){
        return userService.loginUser(user);
    }
}
