package com.holo.ecommerce.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShippingMessageResponse {
    SUCCESSFULLY_CREATED_SHIPPING_METHOD("Successfully created shipping method","message for create"),
    SUCCESSFULLY_DELETE_SHIPPING_METHOD("Successfully deleted shipping method with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_SHIPPING_METHOD("Successfully updated shipping method with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_SHIPPING_METHOD("Successfully find all shipping method","message for find all"),
    SUCCESSFULLY_FIND_SHIPPING_METHOD_BY_ID("Successfully find shipping method with id: ","message for find id");

    private final String message;
    private final String detailMessage;
}
