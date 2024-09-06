package com.holo.ecommerce.order.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.order.entity.OrderLine;
import com.holo.ecommerce.order.enums.OrderMessageResponse;
import com.holo.ecommerce.order.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order/line")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService orderLineService;
    @GetMapping
    public ResponseEntity<RestResponse<List<OrderLine>>> GetAllOrderLine(){
        RestResponse<List<OrderLine>> response = RestResponse.of(orderLineService.GetAllOrderLine());
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_FIND_ALL_ORDER_LINE.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{orderLineId}")
    public ResponseEntity<RestResponse<OrderLine>> GetOrderLineById(Long orderLineId){
        RestResponse<OrderLine> response = RestResponse.of(orderLineService.GetOrderLineById(orderLineId));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_FIND_ORDER_LINE_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{orderLineId}")
    public ResponseEntity<RestResponse<OrderLine>> DeleteOrderLine(Long orderLineId){
        RestResponse<OrderLine> response = RestResponse.of(orderLineService.DeleteOrderLineById(orderLineId));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_FIND_ORDER_LINE_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<OrderLine>> CreateOrderLine(OrderLine orderLine){
        RestResponse<OrderLine> response = RestResponse.of(orderLineService.CreateOrderLine(orderLine));
        response.setMessages(OrderMessageResponse.SUCCESSFULLY_CREATED_ORDER_LINE.getMessage());
        return ResponseEntity.ok(response);
    }
}
