package com.example.SistemaCozinhaComunitaria.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Cadastro_Alimentacao")
public class Alimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String alimentacao;



}
