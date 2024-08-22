package com.holo.ecommerce.customer.address.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressMessageResponse {
    ADDRESS_ENUMS_NOT_FOUND("Address not found!","Please check the id of address.");
    private final String message;
    private final String detailMessage;
}
