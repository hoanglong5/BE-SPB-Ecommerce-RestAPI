package com.holo.ecommerce.review.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReviewExceptionResponse {
    REVIEW_EXCEPTION_RESPONSE_NOT_FOUND("Review not found!","Please check the id of Cart.");
    private final String message;
    private final String detailMessage;
}
