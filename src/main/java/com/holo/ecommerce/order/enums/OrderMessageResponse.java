package com.holo.ecommerce.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderMessageResponse {
    SUCCESSFULLY_CREATED_ORDER("Successfully created order","message for create"),
    SUCCESSFULLY_DELETE_ORDER("Successfully deleted order with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_ORDER("Successfully updated order with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_ORDER("Successfully find all order","message for find all"),
    SUCCESSFULLY_FIND_ORDER_BY_ID("Successfully find order with id: ","message for find id"),

    SUCCESSFULLY_CREATED_ORDER_LINE("Successfully created order line","message for create"),
    SUCCESSFULLY_DELETE_ORDER_LINE("Successfully deleted order line with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_ORDER_LINE("Successfully updated order line with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_ORDER_LINE("Successfully find all order line","message for find all"),
    SUCCESSFULLY_FIND_ORDER_LINE_BY_ID("Successfully find order line with id: ","message for find id"),

    SUCCESSFULLY_CREATED_ORDER_STATUS("Successfully created order status","message for create"),
    SUCCESSFULLY_DELETE_ORDER_STATUS("Successfully deleted order status with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_ORDER_STATUS("Successfully updated order status with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_ORDER_STATUS("Successfully find all order status","message for find all"),
    SUCCESSFULLY_FIND_ORDER_STATUS_BY_ID("Successfully find order status with id: ","message for find id");

    private final String message;
    private final String detailMessage;
}
