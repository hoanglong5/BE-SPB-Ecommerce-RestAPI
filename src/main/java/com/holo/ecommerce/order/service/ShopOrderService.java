package com.holo.ecommerce.order.service;

import com.holo.ecommerce.customer.address.entity.Address;
import com.holo.ecommerce.customer.address.service.AddressService;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.service.UserService;
import com.holo.ecommerce.order.entity.OrderStatus;
import com.holo.ecommerce.order.entity.ShippingMethod;
import com.holo.ecommerce.order.entity.ShopOrder;
import com.holo.ecommerce.order.service.OrderEntityService.ShopOrderEntityService;
import com.holo.ecommerce.payment.entity.UserPaymentMethod;
import com.holo.ecommerce.payment.service.UserPaymentMethodService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopOrderService {
    private final ShopOrderEntityService shopOrderEntityService;
    private final UserService userService;
    private final UserPaymentMethodService userPaymentMethodService;
    private final AddressService addressService;
    private final ShippingMethodService shippingMethodService;
    private final OrderStatusService orderStatusService;

    public List<ShopOrder> GetAllShopOrder(){
        return shopOrderEntityService.GetAllShopOrder();
    }
    public ShopOrder GetShopOrderById(Long shopOrderId){
        return shopOrderEntityService.GetShopOrderById(shopOrderId);
    }
    public ShopOrder DeleteShopOrderById(Long shopOrderId){
        return shopOrderEntityService.DeleteShopOrder(shopOrderId);
    }
    public ShopOrder CreateShopOrder(ShopOrder shopOrderCreating){
        User user = userService.GetUser(shopOrderCreating.getUser().getId());
        UserPaymentMethod userPaymentMethod = userPaymentMethodService.GetUserPaymentMethod(shopOrderCreating.getUserPaymentMethod().getId());
        Address address = addressService.GetAddress(shopOrderCreating.getAddress().getId());
        ShippingMethod shippingMethod = shippingMethodService.GetShippingMethodById(shopOrderCreating.getShippingMethod().getId());
        OrderStatus orderStatus = orderStatusService.GetOrderStatusById(shopOrderCreating.getOrderStatus().getId());
        return shopOrderEntityService.SaveShopOrder(shopOrderCreating);
    }
}
