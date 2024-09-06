package com.holo.ecommerce.order.service.OrderEntityService;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.order.entity.OrderLine;
import com.holo.ecommerce.order.entity.ShippingMethod;
import com.holo.ecommerce.order.enums.OrderExceptionResponse;
import com.holo.ecommerce.order.enums.ShippingExceptionResponse;
import com.holo.ecommerce.order.repository.ShippingMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingMethodEntityService extends BaseService<ShippingMethod, ShippingMethodRepository> {
    public ShippingMethodEntityService(ShippingMethodRepository dao) {
        super(dao);
    }
    public List<ShippingMethod> GetAllShippingMethod(){
        return getDao().findAll();
    }
    public ShippingMethod GetShippingMethodById(Long shippingMethodId){
        return getDao().findById(shippingMethodId).orElseThrow(() -> new ItemNotFoundException(ShippingExceptionResponse.SHIPPING_METHOD_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public ShippingMethod SaveShippingMethod(ShippingMethod shippingMethod){
        return getDao().save(shippingMethod);
    }
    public ShippingMethod DeleteShippingMethod(Long shippingMethodId){
        ShippingMethod shippingMethod = GetShippingMethodById(shippingMethodId);
        getDao().deleteById(shippingMethodId);
        return shippingMethod;
    }
}
