package com.example.SistemaCozinhaComunitaria.Repository;

import com.example.SistemaCozinhaComunitaria.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutosRepository extends JpaRepository <Produtos, UUID>{
}
