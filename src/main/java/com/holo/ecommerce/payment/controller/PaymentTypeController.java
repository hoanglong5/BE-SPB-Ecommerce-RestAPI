package com.holo.ecommerce.payment.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.payment.entity.PaymentType;
import com.holo.ecommerce.payment.enums.PaymentMessageResponse;
import com.holo.ecommerce.payment.service.PaymentTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/payment/type")
public class PaymentTypeController {
    private final PaymentTypeService paymentTypeService;
    @GetMapping()
    public ResponseEntity<RestResponse<List<PaymentType>>> GetAllPaymentType(){
        RestResponse<List<PaymentType>> response = RestResponse.of(paymentTypeService.GetAllPaymentType());
        response.setMessages(PaymentMessageResponse.SUCCESSFULLY_FIND_ALL_PAYMENT_TYPE.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{paymentId}")
    public ResponseEntity<RestResponse<PaymentType>> GetPaymentType(@PathVariable Long paymentId){
        RestResponse<PaymentType> response = RestResponse.of(paymentTypeService.GetPaymentType(paymentId));
        response.setMessages(PaymentMessageResponse.SUCCESSFULLY_FIND_PAYMENT_TYPE_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<RestResponse<PaymentType>> DeletePaymentType(@PathVariable Long paymentId){
        RestResponse<PaymentType> response = RestResponse.of(paymentTypeService.DeletePaymentType(paymentId));
        response.setMessages(PaymentMessageResponse.SUCCESSFULLY_FIND_PAYMENT_TYPE_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<RestResponse<PaymentType>> CreatePaymentType(@RequestBody PaymentType paymentTypeCreating){
        RestResponse<PaymentType> response = RestResponse.of(paymentTypeService.CreatePaymentType(paymentTypeCreating));
        response.setMessages(PaymentMessageResponse.SUCCESSFULLY_DELETE_PAYMENT_TYPE.getMessage());
        return ResponseEntity.ok(response);
    }
}
