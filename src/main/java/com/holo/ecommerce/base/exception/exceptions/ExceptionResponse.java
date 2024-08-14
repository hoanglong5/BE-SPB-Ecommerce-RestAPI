package com.holo.ecommerce.base.exception.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private LocalDate errorDate;
    private String messages;
    private String detail;
    private boolean isSuccess;
}
