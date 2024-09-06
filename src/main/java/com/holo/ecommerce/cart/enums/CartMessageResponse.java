package com.holo.ecommerce.cart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CartMessageResponse {
    SUCCESSFULLY_CREATED_CART("Successfully created cart","message for create"),
    SUCCESSFULLY_DELETE_CART("Successfully deleted cart with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_CART("Successfully updated cart with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_CART("Successfully find all cart","message for find all"),
    SUCCESSFULLY_FIND_CART_BY_ID("Successfully find cart with id: ","message for find id");
    
    
    private final String message;
    private final String detailMessage;
}
