package com.holo.ecommerce.cart.service.CartEntityService;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.cart.entity.Cart;
import com.holo.ecommerce.cart.enums.CartExceptionResponse;
import com.holo.ecommerce.cart.repository.CartRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartEntityService extends BaseService<Cart, CartRepository> {
    public CartEntityService(CartRepository dao) {
        super(dao);
    }
    public List<Cart> GetAllCart() {
        return getDao().findAll();
    }
    public Cart GetCardById(Long cartId){
        return getDao().findById(cartId).orElseThrow(() -> new ItemNotFoundException(CartExceptionResponse.CART_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public Cart SaveCart(Cart cart){
        return getDao().save(cart);
    }
    public Cart DeleteCart(Long cartId){
        Cart cart = GetCardById(cartId);
        getDao().deleteById(cartId);
        return cart;
    }
}
