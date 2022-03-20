package com.supinfo.services;

import com.supinfo.entities.UserEntity;
import com.supinfo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(UserEntity user) {
        userRepository.save(user);
    }

//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
}

