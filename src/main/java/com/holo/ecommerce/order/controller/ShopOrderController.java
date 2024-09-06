package com.holo.ecommerce.order.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.order.entity.ShopOrder;
import com.holo.ecommerce.order.enums.OrderMessageResponse;
import com.holo.ecommerce.order.service.ShopOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/shop")
@RequiredArgsConstructor
public class ShopOrderController {
    private final ShopOrderService shopOrderService;
    @GetMapping
    public ResponseEntity<RestResponse<List<ShopOrder>>> GetAllShopOrder(){
        RestResponse<List<ShopOrder>> response = RestResponse.of(shopOrderService.GetAllShopOrder());
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_FIND_ALL_ORDER.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{shopOrderId}")
    public ResponseEntity<RestResponse<ShopOrder>> GetShopOrderById(Long shopOrderId){
        RestResponse<ShopOrder> response = RestResponse.of(shopOrderService.GetShopOrderById(shopOrderId));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_FIND_ORDER_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{shopOrderId}")
    public ResponseEntity<RestResponse<ShopOrder>> DeleteShopOrder(Long shopOrderId){
        RestResponse<ShopOrder> response = RestResponse.of(shopOrderService.DeleteShopOrderById(shopOrderId));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_DELETE_ORDER.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<ShopOrder>> CreateShopOrder(ShopOrder shopOrder){
        RestResponse<ShopOrder> response = RestResponse.of(shopOrderService.CreateShopOrder(shopOrder));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_CREATED_ORDER.getMessage());
        return ResponseEntity.ok(response);
    }

}
