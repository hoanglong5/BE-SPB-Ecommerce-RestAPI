package com.holo.ecommerce.promotion.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PromotionMessageResponse {
    SUCCESSFULLY_CREATED_PROMOTION("Successfully created promotion","message for create"),
    SUCCESSFULLY_DELETE_PROMOTION("Successfully deleted promotion with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_PROMOTION("Successfully updated promotion with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_PROMOTION("Successfully find all promotions","message for find all"),
    SUCCESSFULLY_FIND_PROMOTION_BY_ID("Successfully find promotion with id: ","message for find id");

    private final String message;
    private final String messageDetail;
}
