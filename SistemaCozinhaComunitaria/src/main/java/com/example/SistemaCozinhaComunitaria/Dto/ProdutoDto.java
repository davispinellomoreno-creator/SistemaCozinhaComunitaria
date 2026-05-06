package com.example.SistemaCozinhaComunitaria.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProdutoDto {

    private Long id;
    private String produto;
    private LocalDate validade;
    private double quantidade;
}
