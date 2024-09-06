package com.holo.ecommerce.order.service.OrderEntityService;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.order.entity.OrderLine;
import com.holo.ecommerce.order.enums.OrderExceptionResponse;
import com.holo.ecommerce.order.repository.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderLineEntityService extends BaseService<OrderLine, OrderLineRepository> {
    public OrderLineEntityService(OrderLineRepository dao) {
        super(dao);
    }
    public List<OrderLine> GetAllOrderLine(){
        return getDao().findAll();
    }
    public OrderLine GetOrderLineById(Long oderLineId){
        return getDao().findById(oderLineId).orElseThrow(() -> new ItemNotFoundException(OrderExceptionResponse.ORDER_LINE_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public OrderLine SaveOrderLine(OrderLine orderLine){
        return getDao().save(orderLine);
    }
    public OrderLine DeleteOrderLine(Long orderLineId){
        OrderLine orderLine = GetOrderLineById(orderLineId);
        getDao().deleteById(orderLineId);
        return orderLine;
    }
}
