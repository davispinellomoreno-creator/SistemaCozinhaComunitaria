package com.example.SistemaCozinhaComunitaria.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Cadastro_Usuario")
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

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<Produtos> produtos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    private List<Alimentacao> alimentacoes = new ArrayList<>();
}
