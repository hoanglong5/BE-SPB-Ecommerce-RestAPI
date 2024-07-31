package com.holo.ecommerce.customer.customer.service;

import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> GetAllUser(){
        return userRepository.findAll();
    }
    public User getUserWithAddress(Long userID){
        return userRepository.findById(userID).orElseThrow(RuntimeException::new);
    }
}
