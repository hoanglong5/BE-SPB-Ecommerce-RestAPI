package com.holo.ecommerce.order.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.order.entity.OrderStatus;
import com.holo.ecommerce.order.enums.OrderMessageResponse;
import com.holo.ecommerce.order.service.OrderStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/status")
@RequiredArgsConstructor
public class OrderStatusController {
    private final OrderStatusService orderStatusService;
    @GetMapping
    public ResponseEntity<RestResponse<List<OrderStatus>>> GetAllOrderStatus(){
        RestResponse<List<OrderStatus>> response = RestResponse.of(orderStatusService.GetAllOrderStatus());
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_FIND_ALL_ORDER_STATUS.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{orderStatusId}")
    public ResponseEntity<RestResponse<OrderStatus>> GetOrderStatusById(Long orderStatusId){
        RestResponse<OrderStatus> response = RestResponse.of(orderStatusService.GetOrderStatusById(orderStatusId));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_FIND_ORDER_STATUS_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{orderStatusId}")
    public ResponseEntity<RestResponse<OrderStatus>> DeleteOrderStatus(Long orderStatusId){
        RestResponse<OrderStatus> response = RestResponse.of(orderStatusService.DeleteOrderStatusById(orderStatusId));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_DELETE_ORDER_STATUS.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<OrderStatus>> CreateOrderStatus(OrderStatus orderStatus){
        RestResponse<OrderStatus> response = RestResponse.of(orderStatusService.CreateOrderStatus(orderStatus));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_CREATED_ORDER_STATUS.getMessage());
        return ResponseEntity.ok(response);
    }

}
