package com.holo.ecommerce.order.service.OrderEntityService;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.order.entity.OrderLine;
import com.holo.ecommerce.order.entity.OrderStatus;
import com.holo.ecommerce.order.enums.OrderExceptionResponse;
import com.holo.ecommerce.order.repository.OrderStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusEntityService extends BaseService<OrderStatus, OrderStatusRepository> {
    public OrderStatusEntityService(OrderStatusRepository dao) {
        super(dao);
    }
    public List<OrderStatus> GetAllOrderStatus(){
        return getDao().findAll();
    }
    public OrderStatus GetOrderStatusById(Long orderStatusId){
        return getDao().findById(orderStatusId).orElseThrow(() -> new ItemNotFoundException(OrderExceptionResponse.ORDER_STATUS_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public OrderStatus SaveOrderStatus(OrderStatus orderStatus ){
        return getDao().save(orderStatus);
    }
    public OrderStatus DeleteOrderStatus(Long orderStatusId ){
        OrderStatus orderStatus = GetOrderStatusById(orderStatusId);
        getDao().deleteById(orderStatusId);
        return orderStatus;
    }
}
