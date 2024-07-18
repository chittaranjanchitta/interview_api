package com.example1.demoExample.service;


import com.example1.demoExample.entity.User;
import com.example1.demoExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example1.demoExample.dto.UserDTO;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    User user = new User();
    UserDTO userDTO = new UserDTO();



        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}