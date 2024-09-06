package com.holo.ecommerce.order.service.OrderEntityService;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.order.entity.OrderLine;
import com.holo.ecommerce.order.entity.ShopOrder;
import com.holo.ecommerce.order.enums.OrderExceptionResponse;
import com.holo.ecommerce.order.repository.ShopOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopOrderEntityService extends BaseService<ShopOrder, ShopOrderRepository> {
    public ShopOrderEntityService(ShopOrderRepository dao) {
        super(dao);
    }
    public List<ShopOrder> GetAllShopOrder(){
        return getDao().findAll();
    }
    public ShopOrder GetShopOrderById(Long shopOrderId){
        return getDao().findById(shopOrderId).orElseThrow(() -> new ItemNotFoundException(OrderExceptionResponse.ORDER_STATUS_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public ShopOrder SaveShopOrder(ShopOrder shopOrder){
        return getDao().save(shopOrder);
    }
    public ShopOrder DeleteShopOrder(Long shopOrderId){
        ShopOrder shopOrder = GetShopOrderById(shopOrderId);
        getDao().deleteById(shopOrderId);
        return shopOrder;
    }
}
