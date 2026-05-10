package com.example.SistemaCozinhaComunitaria.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ApiError(
        int status,
        String error,
        String message,
        LocalDateTime timestamp
) {
}
