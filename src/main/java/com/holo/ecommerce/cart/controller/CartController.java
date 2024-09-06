package com.holo.ecommerce.cart.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.cart.entity.Cart;
import com.holo.ecommerce.cart.enums.CartMessageResponse;
import com.holo.ecommerce.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @GetMapping
    public ResponseEntity<RestResponse<List<Cart>>> GetAllCart(){
        RestResponse<List<Cart>> response = RestResponse.of(cartService.GetAllCart());
        response.setMessages(CartMessageResponse.SUCCESSFULLY_FIND_ALL_CART.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{cartId}")
    public ResponseEntity<RestResponse<Cart>> GetCartById(Long cartId){
        RestResponse<Cart> response = RestResponse.of(cartService.GetCartById(cartId));
        response.setMessages(CartMessageResponse.SUCCESSFULLY_FIND_CART_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{cartId}")
    public ResponseEntity<RestResponse<Cart>> DeleteCartById(Long cartId){
        RestResponse<Cart> response = RestResponse.of(cartService.DeleteCartById(cartId));
        response.setMessages(CartMessageResponse.SUCCESSFULLY_DELETE_CART.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<RestResponse<Cart>> CreateCart(Cart cartCreating){
        RestResponse<Cart> response = RestResponse.of(cartService.CreateCart(cartCreating));
        response.setMessages(CartMessageResponse.SUCCESSFULLY_CREATED_CART.getMessage());
        return ResponseEntity.ok(response);
    }
}
