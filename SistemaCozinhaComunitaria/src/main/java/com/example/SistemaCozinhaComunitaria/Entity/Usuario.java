package com.example.SistemaCozinhaComunitaria.Entity;

import jakarta.persistence.*;

import java.util.UUID;

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private String perfil;

    private Boolean ativo;
}
