package com.holo.ecommerce.payment.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentExceptionMessage {
    //Payment type
    PAYMENT_TYPE_NOT_FOUND("Payment type not found!","Please check the id of payment type."),
    //Payment method
    PAYMENT_METHOD_NOT_FOUND("Payment method not found!","Please check the id of payment method.");
    private final String message;
    private final String detailMessage;
}
