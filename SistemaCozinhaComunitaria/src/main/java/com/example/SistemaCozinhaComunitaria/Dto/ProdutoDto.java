package com.example.SistemaCozinhaComunitaria.Dto;

import java.time.LocalDate;
import java.util.UUID;

public record ProdutoDto(UUID id, String produtos, LocalDate validade,
                         double quantidade, String criadoPor) {
}
