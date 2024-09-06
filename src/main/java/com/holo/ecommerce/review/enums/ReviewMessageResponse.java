package com.holo.ecommerce.review.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReviewMessageResponse {
    SUCCESSFULLY_CREATED_REVIEW("Successfully created review","message for create"),
    SUCCESSFULLY_DELETE_REVIEW("Successfully deleted review with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_REVIEW("Successfully updated review with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_REVIEW("Successfully find all review","message for find all"),
    SUCCESSFULLY_FIND_REVIEW_BY_ID("Successfully find review with id: ","message for find id");


    private final String message;
    private final String detailMessage;
}
