package com.holo.ecommerce.cart.service;

import com.holo.ecommerce.cart.entity.CartItem;
import com.holo.ecommerce.cart.service.CartEntityService.CartItemEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CartItemService {
    private final CartItemEntityService cartItemEntityService;
    private final CartService cartService;
    public List<CartItem> GetAllCartItem(){
        return cartItemEntityService.GetAllCartItem();
    }
    public CartItem GetCartItemById(Long cartItemId){
        return cartItemEntityService.GetCardItemById(cartItemId);
    }
    @Transactional
    public CartItem DeleteCartItemById(Long cartItemId){
        return cartItemEntityService.DeleteCartItem(cartItemId);
    }
    @Transactional
    public CartItem UpdateCartItem(Long cartItemId,CartItem cartItemUpdating){
        CartItem cartItem = cartItemEntityService.GetCardItemById(cartItemId);
        cartItem.setQuantity(cartItemUpdating.getQuantity());
        cartItem.setProductItem(cartItemUpdating.getProductItem());
        cartItemEntityService.SaveCartItem(cartItem);
        return cartItem;
    }
    @Transactional
    public CartItem CreateCartItem(CartItem cartItemCreating){
        cartService.GetCartById(cartItemCreating.getCart().getId());
        return cartItemEntityService.SaveCartItem(cartItemCreating);
    }
}
