package com.holo.ecommerce.customer.customer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserExceptionResponse {
    USER_NOT_FOUND("User not found!","Please check the id of user."),
    EMAIL_NOT_FOUND("Wrong email or password","please check email");
    private final String message;
    private final String detailMessage;
}
