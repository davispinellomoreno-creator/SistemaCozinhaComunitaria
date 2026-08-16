package com.example.SistemaCozinhaComunitaria.Dto;

import com.example.SistemaCozinhaComunitaria.Enum.Perfil;

import java.util.UUID;

public record UsuarioListagemDto(UUID id, String nome, String email, Boolean ativo, Perfil perfil) {
}