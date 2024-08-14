package com.holo.ecommerce.customer.customer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserExceptionMessage {
    USER_NOT_FOUND("User not found!","Please check the id of user.");
    private final String message;
    private final String detailMessage;
}
