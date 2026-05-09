package com.example.SistemaCozinhaComunitaria.Dto;

import java.time.LocalDate;

public record ProdutoDto(java.util.UUID id, String produtos,
                         LocalDate validade, double quantidade) {
}
