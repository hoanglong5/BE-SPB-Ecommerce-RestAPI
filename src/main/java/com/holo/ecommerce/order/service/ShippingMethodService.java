package com.holo.ecommerce.order.service;

import com.holo.ecommerce.order.entity.ShippingMethod;
import com.holo.ecommerce.order.service.OrderEntityService.ShippingMethodEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingMethodService {
    private final ShippingMethodEntityService shippingMethodEntityService;
    public List<ShippingMethod> GetAllShippingMethod(){
        return shippingMethodEntityService.GetAllShippingMethod();
    }
    public ShippingMethod GetShippingMethodById(Long shippingMethodId){
        return shippingMethodEntityService.GetShippingMethodById(shippingMethodId);
    }
    public ShippingMethod DeleteShippingMethodById(Long shippingMethodId){
        return shippingMethodEntityService.DeleteShippingMethod(shippingMethodId);
    }
    public ShippingMethod CreateShippingMethod(ShippingMethod shippingMethod){
        return shippingMethodEntityService.SaveShippingMethod(shippingMethod);
    }
}
