package com.example.SistemaCozinhaComunitaria.Dto;

import java.util.UUID;

public record AlimentacaoDto(java.util.UUID id, String alimentacao) {
    public AlimentacaoDto(UUID id, String nome, String email, String senha, Boolean ativo) {
    }
}
