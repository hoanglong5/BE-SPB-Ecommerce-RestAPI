package com.holo.ecommerce.customer.address.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressEnums {
    USER_NOT_FOUND("User not found!","Please check the id of user.");
    private final String message;
    private final String detailMessage;
}
