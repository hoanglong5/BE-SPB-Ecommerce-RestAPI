package com.holo.ecommerce.order.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.order.entity.ShippingMethod;
import com.holo.ecommerce.order.enums.ShippingMessageResponse;
import com.holo.ecommerce.order.service.ShippingMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/shipping")
@RequiredArgsConstructor
public class ShippingMethodController {
    private final ShippingMethodService shippingMethodService;
    @GetMapping
    public ResponseEntity<RestResponse<List<ShippingMethod>>> GetAllShippingMethod(){
        RestResponse<List<ShippingMethod>> response = RestResponse.of(shippingMethodService.GetAllShippingMethod());
        response.setMessages(ShippingMessageResponse.SUCCESSFULLY_FIND_ALL_SHIPPING_METHOD.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{shippingMethodId}")
    public ResponseEntity<RestResponse<ShippingMethod>> GetShippingMethodById(Long shippingMethodId){
        RestResponse<ShippingMethod> response = RestResponse.of(shippingMethodService.GetShippingMethodById(shippingMethodId));
        response.setMessages(ShippingMessageResponse.SUCCESSFULLY_FIND_SHIPPING_METHOD_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{shippingMethodId}")
    public ResponseEntity<RestResponse<ShippingMethod>> DeleteShippingMethod(Long shippingMethodId){
        RestResponse<ShippingMethod> response = RestResponse.of(shippingMethodService.DeleteShippingMethodById(shippingMethodId));
        response.setMessages(ShippingMessageResponse.SUCCESSFULLY_DELETE_SHIPPING_METHOD.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<RestResponse<ShippingMethod>> CreateShippingMethod(ShippingMethod shippingMethod){
        RestResponse<ShippingMethod> response = RestResponse.of(shippingMethodService.CreateShippingMethod(shippingMethod));
        response.setMessages(ShippingMessageResponse.SUCCESSFULLY_FIND_SHIPPING_METHOD_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
}
