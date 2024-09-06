package com.holo.ecommerce.cart.service.CartEntityService;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.cart.entity.Cart;
import com.holo.ecommerce.cart.entity.CartItem;
import com.holo.ecommerce.cart.enums.CartExceptionResponse;
import com.holo.ecommerce.cart.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemEntityService extends BaseService<CartItem, CartItemRepository> {
    public CartItemEntityService(CartItemRepository dao) {
        super(dao);
    }
    public List<CartItem> GetAllCartItem() {
        return getDao().findAll();
    }
    public CartItem GetCardItemById(Long cartItemId){
        return getDao().findById(cartItemId).orElseThrow(() -> new ItemNotFoundException(CartExceptionResponse.CART_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public CartItem SaveCartItem(CartItem cartItem){
        return getDao().save(cartItem);
    }
    public CartItem DeleteCartItem(Long cartItemId){
        CartItem cartItem = GetCardItemById(cartItemId);
        getDao().deleteById(cartItemId);
        return cartItem;
    }
}
