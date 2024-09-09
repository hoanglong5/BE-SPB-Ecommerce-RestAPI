package com.holo.ecommerce.config.auth.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.config.auth.entity.AuthenticationRequest;
import com.holo.ecommerce.config.auth.entity.AuthenticationResponse;
import com.holo.ecommerce.config.auth.enums.AuthenticationMessageResponse;
import com.holo.ecommerce.config.auth.service.AuthenticationService;
import com.holo.ecommerce.customer.customer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<RestResponse<AuthenticationResponse>> authenticate(@RequestBody AuthenticationRequest request){
        boolean result = authenticationService.authenticate(request);
        AuthenticationResponse auth = AuthenticationResponse.builder().isAuthenticated(result).build();
        RestResponse<AuthenticationResponse> response = RestResponse.of(auth);
        if (result){
            response.setMessages(AuthenticationMessageResponse.AUTHENTICATE_SUCCESSFUL.getMessage());
        }else {
            response.setMessages(AuthenticationMessageResponse.AUTHENTICATE_FAILURE.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
