package com.holo.ecommerce.config.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuthenticationMessageResponse {
    AUTHENTICATE_SUCCESSFUL("Authenticate successful","Congratulation !"),
    AUTHENTICATE_FAILURE("Wrong email or password","Try again !");

    private final String message;
    private final String detailMessage;
}
