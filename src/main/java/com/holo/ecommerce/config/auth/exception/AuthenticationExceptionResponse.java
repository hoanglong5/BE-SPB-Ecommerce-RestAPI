package com.holo.ecommerce.config.auth.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationExceptionResponse {
    private boolean isAuthenticated;
    private LocalDate errorDate;
    private String messages;
    private String detail;
    private boolean isSuccess;
}
