package com.example.SistemaCozinhaComunitaria.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Cadastro_Produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String produto;
    private LocalDate validade;
    private double quantidade;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;



}
