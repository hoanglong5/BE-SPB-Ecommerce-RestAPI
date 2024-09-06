package com.holo.ecommerce.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShippingExceptionResponse {
    SHIPPING_METHOD_EXCEPTION_RESPONSE_NOT_FOUND("Shipping method is not found!","Please check the id of Cart.");
    private final String message;
    private final String detailMessage;
}
