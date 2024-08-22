package com.holo.ecommerce.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductMessageResponse {
    //Product
    SUCCESSFULLY_CREATED_PRODUCT("Successfully created promotion","message for create"),
    SUCCESSFULLY_DELETE_PRODUCT("Successfully deleted promotion with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_PRODUCT("Successfully updated promotion with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_PRODUCT("Successfully find all promotions","message for find all"),
    SUCCESSFULLY_FIND_PRODUCT_BY_ID("Successfully find promotion with id: ","message for find id"),
    //Product item
    SUCCESSFULLY_CREATED_PRODUCT_ITEM("Successfully created promotion","message for create"),
    SUCCESSFULLY_DELETE_PRODUCT_ITEM("Successfully deleted promotion with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_PRODUCT_ITEM("Successfully updated promotion with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_PRODUCT_ITEM("Successfully find all promotions","message for find all"),
    SUCCESSFULLY_FIND_PRODUCT_ITEM_BY_ID("Successfully find promotion with id: ","message for find id"),
    //Variation option
    SUCCESSFULLY_CREATED_VARIATION_OPTION("Successfully created promotion","message for create"),
    SUCCESSFULLY_DELETE_VARIATION_OPTION("Successfully deleted promotion with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_VARIATION_OPTION("Successfully updated promotion with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_VARIATION_OPTION("Successfully find all promotions","message for find all"),
    SUCCESSFULLY_FIND_VARIATION_OPTION_BY_ID("Successfully find promotion with id: ","message for find id"),
    //Variation
    SUCCESSFULLY_CREATED_VARIATION("Successfully created promotion","message for create"),
    SUCCESSFULLY_DELETE_VARIATION("Successfully deleted promotion with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_VARIATION("Successfully updated promotion with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_VARIATION("Successfully find all promotions","message for find all"),
    SUCCESSFULLY_FIND_VARIATION_BY_ID("Successfully find promotion with id: ","message for find id");
    private final String message;
    private final String messageDetail;
}
