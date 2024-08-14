package com.holo.ecommerce.payment.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMessage {
    //Payment type
    SUCCESSFULLY_CREATED_PAYMENT_TYPE("Successfully created payment type","message for create"),
    SUCCESSFULLY_DELETE_PAYMENT_TYPE("Successfully deleted payment type with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_PAYMENT_TYPE("Successfully updated payment type with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_PAYMENT_TYPE("Successfully find all payment types","message for find all"),
    SUCCESSFULLY_FIND_PAYMENT_TYPE_BY_ID("Successfully find payment type with id: ","message for find id"),

    //Payment method
    SUCCESSFULLY_CREATED_PAYMENT_METHOD("Successfully created payment method","message for create"),
    SUCCESSFULLY_DELETE_PAYMENT_METHOD("Successfully deleted payment method with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_PAYMENT_METHOD("Successfully updated payment method with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_PAYMENT_METHOD("Successfully find all payment methods","message for find all"),
    SUCCESSFULLY_FIND_PAYMENT_BY_ID_METHOD("Successfully find payment method with id: ","message for find id");
    private final String message;
    private final String messageDetail;
}
