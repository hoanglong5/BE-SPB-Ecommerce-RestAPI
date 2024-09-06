package com.holo.ecommerce.cart.service;

import com.holo.ecommerce.cart.entity.Cart;
import com.holo.ecommerce.cart.service.CartEntityService.CartEntityService;
import com.holo.ecommerce.customer.customer.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private final CartEntityService cartEntityService;
    private final UserService userService;
    public List<Cart> GetAllCart(){
        return cartEntityService.GetAllCart();
    }
    public Cart GetCartById(Long cartId){
        return cartEntityService.GetCardById(cartId);
    }
    @Transactional
    public Cart DeleteCartById(Long cartId){
        return cartEntityService.DeleteCart(cartId);
    }
    @Transactional
    public Cart CreateCart(Cart cart){
        userService.GetUser(cart.getUser().getId());
        return cartEntityService.SaveCart(cart);
    }
}
