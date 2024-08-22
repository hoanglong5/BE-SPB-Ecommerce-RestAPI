package com.holo.ecommerce.category.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryExceptionResponse {
    CATEGORY_EXCEPTION_RESPONSE_NOT_FOUND("Category not found!","Please check the id of Category.");
    private final String message;
    private final String detailMessage;
}
