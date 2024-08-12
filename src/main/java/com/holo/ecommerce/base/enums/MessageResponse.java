package com.holo.ecommerce.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageResponse {
    SUCCESSFULLY_CREATED("Successfully created item","message for create"),
    SUCCESSFULLY_DELETE("Successfully deleted id: ","message for delete"),
    SUCCESSFULLY_UPDATED("Successfully updated id: ","message for delete"),
    SUCCESSFULLY_FINDALL("Successfully find all item","message for find all"),
    SUCCESSFULLY_FINDBYID("Successfully find id: ","message for find id");

    private String message;
    private String messageDetail;
}
