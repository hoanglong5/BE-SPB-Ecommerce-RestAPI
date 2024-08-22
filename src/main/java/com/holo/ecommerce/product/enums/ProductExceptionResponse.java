package com.holo.ecommerce.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductExceptionResponse {
    //Product
    PRODUCT_EXCEPTION_RESPONSE_NOT_FOUND("Product not found!","Please check the id of Product."),
    //Product item
    PRODUCT_ITEM_EXCEPTION_RESPONSE_NOT_FOUND("Product item not found!","Please check the id of Product."),
    //Variations
    VARIATION_EXCEPTION_RESPONSE_NOT_FOUND("Variation not found!","Please check the id of Product."),
    //Variation option
    VARIATION_OPTION_EXCEPTION_RESPONSE_NOT_FOUND("Variation option not found!","Please check the id of Product.");

    private final String message;
    private final String detailMessage;
}
