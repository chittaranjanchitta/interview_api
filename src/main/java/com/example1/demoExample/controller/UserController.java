package com.example1.demoExample.controller;

import com.example1.demoExample.entity.User;
import com.example1.demoExample.service.UserService;
import com.example1.demoExample.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public String signUp(@RequestBody User user) {
        User savedUser = userService.save(user);
        String chitta1 =  jwtUtil.generateToken(savedUser.getUsername());
        return new ResponseEntity<>(chitta1, HttpStatus.CREATED);
    }
}