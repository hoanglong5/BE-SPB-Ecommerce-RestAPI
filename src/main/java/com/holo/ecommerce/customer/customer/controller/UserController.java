package com.holo.ecommerce.customer.customer.controller;

import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping()
    public ResponseEntity<List<User>> GetAllUser(){
        return ResponseEntity.ok(userService.GetAllUser());
    }
    @GetMapping("/{userID}")
    public ResponseEntity<User> GetUser(@PathVariable Long userID){
        User user = userService.getUserWithAddress(userID);
        return ResponseEntity.ok(user);
    }
}
