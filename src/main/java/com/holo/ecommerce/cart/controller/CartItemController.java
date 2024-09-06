package com.holo.ecommerce.cart.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.cart.entity.Cart;
import com.holo.ecommerce.cart.entity.CartItem;
import com.holo.ecommerce.cart.enums.CartMessageResponse;
import com.holo.ecommerce.cart.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart/item")
@RequiredArgsConstructor
public class CartItemController {
    private final CartItemService cartItemService;
    @GetMapping
    public ResponseEntity<RestResponse<List<CartItem>>> GetAllCartItem(){
        RestResponse<List<CartItem>> response = RestResponse.of(cartItemService.GetAllCartItem());
        response.setMessages(CartMessageResponse.SUCCESSFULLY_FIND_ALL_CART.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{cartItemId}")
    public ResponseEntity<RestResponse<CartItem>> GetCartItemById(Long cartItemId){
        RestResponse<CartItem> response = RestResponse.of(cartItemService.GetCartItemById(cartItemId));
        response.setMessages(CartMessageResponse.SUCCESSFULLY_FIND_CART_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<RestResponse<CartItem>> DeleteCartById(Long cartItemId){
        RestResponse<CartItem> response = RestResponse.of(cartItemService.DeleteCartItemById(cartItemId));
        response.setMessages(CartMessageResponse.SUCCESSFULLY_DELETE_CART.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<RestResponse<CartItem>> CreateCart(CartItem cartItemCreating){
        RestResponse<CartItem> response = RestResponse.of(cartItemService.CreateCartItem(cartItemCreating));
        response.setMessages(CartMessageResponse.SUCCESSFULLY_CREATED_CART.getMessage());
        return ResponseEntity.ok(response);
    }
}
