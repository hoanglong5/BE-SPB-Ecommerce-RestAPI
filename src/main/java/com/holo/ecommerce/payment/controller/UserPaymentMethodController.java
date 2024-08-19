package com.holo.ecommerce.payment.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.payment.entity.UserPaymentMethod;
import com.holo.ecommerce.payment.enums.PaymentMessage;
import com.holo.ecommerce.payment.service.UserPaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/payment/method")
public class UserPaymentMethodController {
    private final UserPaymentMethodService userPaymentMethodService;

    @GetMapping()
    public ResponseEntity<RestResponse<List<UserPaymentMethod>>> GetAllPaymentMethod(){
        RestResponse<List<UserPaymentMethod>> response = RestResponse.of(userPaymentMethodService.GetAllUserPaymentMethod());
        response.setMessages(PaymentMessage.SUCCESSFULLY_FIND_ALL_PAYMENT_METHOD.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/methodId")
    public ResponseEntity<RestResponse<UserPaymentMethod>> GetPaymentMethod(@PathVariable Long methodId){
        RestResponse<UserPaymentMethod> response = RestResponse.of(userPaymentMethodService.GetUserPaymentMethod(methodId));
        response.setMessages(PaymentMessage.SUCCESSFULLY_FIND_PAYMENT_BY_ID_METHOD.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/methodId")
    public ResponseEntity<RestResponse<UserPaymentMethod>>DeletePaymentMethod(@PathVariable Long methodId){
        RestResponse<UserPaymentMethod> response = RestResponse.of(userPaymentMethodService.DeleteUserPaymentMethod(methodId));
        response.setMessages(PaymentMessage.SUCCESSFULLY_FIND_PAYMENT_BY_ID_METHOD.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<RestResponse<UserPaymentMethod>>CreatePaymentMethod(@RequestBody UserPaymentMethod userPaymentMethodCreating){
        RestResponse<UserPaymentMethod> response = RestResponse.of(userPaymentMethodService.CreateUserPaymentMethod(userPaymentMethodCreating));
        response.setMessages(PaymentMessage.SUCCESSFULLY_CREATED_PAYMENT_METHOD.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/paymentId")
    public ResponseEntity<RestResponse<UserPaymentMethod>>UpdatePaymentMethod(@PathVariable Long paymentId,@RequestBody UserPaymentMethod userPaymentMethodUpdating){
        RestResponse<UserPaymentMethod> response = RestResponse.of(userPaymentMethodService.UpdateUserPaymentMethod(paymentId,userPaymentMethodUpdating));
        response.setMessages(PaymentMessage.SUCCESSFULLY_UPDATED_PAYMENT_METHOD.getMessage());
        return ResponseEntity.ok(response);
    }
}