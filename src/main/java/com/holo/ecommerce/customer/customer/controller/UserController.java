package com.holo.ecommerce.customer.customer.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.base.enums.MessageResponse;
import com.holo.ecommerce.customer.address.entity.Address;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping()
    public ResponseEntity<RestResponse<List<User>>> GetAllUser(){
        RestResponse<List<User>> response = RestResponse.of(userService.GetAllUser());
        response.setMessages(MessageResponse.SUCCESSFULLY_FINDALL.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<RestResponse<User>> GetUser(@PathVariable Long userId){
        RestResponse<User> response = RestResponse.of(userService.GetUser(userId));
        response.setMessages(MessageResponse.SUCCESSFULLY_FINDBYID.getMessage() + userId.toString());
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<RestResponse<User>> CreateUser(@RequestBody User userCreating){
        RestResponse<User> response = RestResponse.of(userService.CreateUser(userCreating));
        response.setMessages(MessageResponse.SUCCESSFULLY_CREATED.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<RestResponse<User>> DeleteUser(@PathVariable Long userId){
        RestResponse<User> response = RestResponse.of(userService.DeleteUser(userId));
        response.setMessages(MessageResponse.SUCCESSFULLY_DELETE.getMessage() + userId.toString());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{userId}/{addressId}")
    public ResponseEntity<RestResponse<User>> UpdateAddressUser(@PathVariable Long userId, Long addressId, Address addressUpdating){
        RestResponse<User> response = RestResponse.of(userService.UpdateOnlyAddress(userId,addressId,addressUpdating));
        response.setMessages(MessageResponse.SUCCESSFULLY_UPDATED.getMessage() + userId.toString());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<RestResponse<User>> UpdateUser(@RequestBody User userUpdating,@PathVariable Long userId){
        RestResponse<User> response = RestResponse.of(userService.UpdateUser(userId,userUpdating));
        response.setMessages(MessageResponse.SUCCESSFULLY_UPDATED.getMessage() + userId.toString());
        return ResponseEntity.ok(response);
    }
}
