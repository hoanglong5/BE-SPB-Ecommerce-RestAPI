package com.holo.ecommerce.promotion.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PromotionExceptionResponse {
    PROMOTION_EXCEPTION_RESPONSE_NOT_FOUND("Promotion not found!","Please check the id of Promotion.");
    private final String message;
    private final String detailMessage;
}
