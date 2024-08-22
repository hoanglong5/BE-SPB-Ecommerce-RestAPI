package com.holo.ecommerce.category.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryMessageResponse {
    SUCCESSFULLY_CREATED_CATEGORY("Successfully created category","message for create"),
    SUCCESSFULLY_DELETE_CATEGORY("Successfully deleted category with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_CATEGORY("Successfully updated category with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_CATEGORY("Successfully find all category","message for find all"),
    SUCCESSFULLY_FIND_CATEGORY_BY_ID("Successfully find category with id: ","message for find id");

    private final String message;
    private final String messageDetail;
}
