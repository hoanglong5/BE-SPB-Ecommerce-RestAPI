package com.holo.ecommerce.order.service;

import com.holo.ecommerce.order.entity.OrderLine;
import com.holo.ecommerce.order.entity.ShopOrder;
import com.holo.ecommerce.order.service.OrderEntityService.OrderLineEntityService;
import com.holo.ecommerce.product.entity.ProductItem;
import com.holo.ecommerce.product.service.ProductItemService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineEntityService orderLineEntityService;
    private final ShopOrderService shopOrderService;
    private final ProductItemService productItemService;
    public List<OrderLine> GetAllOrderLine(){
        return orderLineEntityService.GetAllOrderLine();
    }
    public OrderLine GetOrderLineById(Long orderLineId){
        return orderLineEntityService.GetOrderLineById(orderLineId);
    }
    public OrderLine DeleteOrderLineById(Long orderLineId){
        return orderLineEntityService.DeleteOrderLine(orderLineId);
    }
    public OrderLine CreateOrderLine(OrderLine orderLineCreating){
        ShopOrder shopOrder = shopOrderService.GetShopOrderById(orderLineCreating.getShopOrder().getId());
        ProductItem productItem =  productItemService.GetProductItem(orderLineCreating.getProductItem().getId());
        return orderLineEntityService.SaveOrderLine(orderLineCreating);
    }
}
