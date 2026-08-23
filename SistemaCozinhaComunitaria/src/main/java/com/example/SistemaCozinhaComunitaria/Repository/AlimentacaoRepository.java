package com.example.SistemaCozinhaComunitaria.Repository;

import com.example.SistemaCozinhaComunitaria.Entity.Alimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface AlimentacaoRepository extends JpaRepository<Alimentacao, UUID> {
    List<Alimentacao> findByUsuarioId(UUID id);
}
