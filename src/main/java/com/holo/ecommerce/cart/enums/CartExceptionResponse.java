package com.holo.ecommerce.cart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CartExceptionResponse {
    CART_EXCEPTION_RESPONSE_NOT_FOUND("Cart not found!","Please check the id of Cart.");
    private final String message;
    private final String detailMessage;
}
