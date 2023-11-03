package com.cassan.swimy.sampler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassan.swimy.sampler.entity.User;
import com.cassan.swimy.sampler.repository.UserRepository;

@Service
public class UserService {
 
    @Autowired
    private UserRepository userRepository;
 
    public List<User> getUsers() {
        return userRepository.findAll();
    }
 
    // createUser, updateUser, deleteUser 등의 메서드 생략
}