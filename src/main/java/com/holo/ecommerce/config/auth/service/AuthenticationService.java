package com.holo.ecommerce.config.auth.service;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.config.auth.entity.AuthenticationRequest;
import com.holo.ecommerce.config.auth.enums.AuthenticationMessageResponse;
import com.holo.ecommerce.config.auth.exception.WrongCredentialException;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;

     public boolean authenticate(AuthenticationRequest request){
         User user = userService.GetUserByEmail(request.getEmail());
         PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
         boolean isAuthenticate = passwordEncoder.matches(request.getPassword(),user.getPassword());
         if (!isAuthenticate){
             throw new WrongCredentialException(AuthenticationMessageResponse.AUTHENTICATE_FAILURE.getMessage());
         }
         return isAuthenticate;
    }
}
