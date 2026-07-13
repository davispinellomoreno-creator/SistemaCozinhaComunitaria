package com.example.SistemaCozinhaComunitaria.Dto;

import java.util.UUID;

public record UsuarioDto(UUID id, String nome, String email, String senha, Boolean ativo) {
    public UsuarioDto {
        if (ativo == null) {
            ativo = true; // valor padrão se o front não enviar
        }
    }
}
