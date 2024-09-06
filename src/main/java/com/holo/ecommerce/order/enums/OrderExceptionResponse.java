package com.holo.ecommerce.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderExceptionResponse {
    ORDER_EXCEPTION_RESPONSE_NOT_FOUND("Order not found!","Please check the id of Cart."),
    ORDER_LINE_EXCEPTION_RESPONSE_NOT_FOUND("Order line not found!","Please check the id of Cart."),
    ORDER_STATUS_EXCEPTION_RESPONSE_NOT_FOUND("Order status not found!","Please check the id of Cart.");
    private final String message;
    private final String detailMessage;
}
