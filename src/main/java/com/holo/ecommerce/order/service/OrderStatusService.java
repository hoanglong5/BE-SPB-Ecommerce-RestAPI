package com.holo.ecommerce.order.service;

import com.holo.ecommerce.order.entity.OrderStatus;
import com.holo.ecommerce.order.service.OrderEntityService.OrderStatusEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderStatusService {
    private final OrderStatusEntityService orderStatusEntityService;
    public List<OrderStatus> GetAllOrderStatus(){
        return orderStatusEntityService.GetAllOrderStatus();
    }
    public OrderStatus GetOrderStatusById(Long shopOrderId){
        return orderStatusEntityService.GetOrderStatusById(shopOrderId);
    }
    public OrderStatus DeleteOrderStatusById(Long shopOrderId){
        return orderStatusEntityService.DeleteOrderStatus(shopOrderId);
    }
    public OrderStatus CreateOrderStatus(OrderStatus orderStatus){
        return orderStatusEntityService.SaveOrderStatus(orderStatus);
    }
}
