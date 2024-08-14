package com.holo.ecommerce.customer.customer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserMessageResponse {
    SUCCESSFULLY_CREATED_USER("Successfully created user","message for create"),
    SUCCESSFULLY_DELETE_USER("Successfully deleted user with id: ","message for delete"),
    SUCCESSFULLY_UPDATED_USER("Successfully updated user with id: ","message for update"),
    SUCCESSFULLY_FIND_ALL_USER("Successfully find all users","message for find all"),
    SUCCESSFULLY_FIND_USER_BY_ID("Successfully find user with id: ","message for find id");

    private final String message;
    private final String messageDetail;
}
