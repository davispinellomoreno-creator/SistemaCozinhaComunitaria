package com.example.SistemaCozinhaComunitaria.Dto;

import com.example.SistemaCozinhaComunitaria.Enum.Perfil;

import java.util.UUID;

public record UsuarioDto(UUID id, String nome, String email, String senha, Boolean ativo, Perfil perfil) {
    public UsuarioDto {
        if (ativo == null) {
            ativo = true; // valor padrão se o front não enviar
        }
    }
}
