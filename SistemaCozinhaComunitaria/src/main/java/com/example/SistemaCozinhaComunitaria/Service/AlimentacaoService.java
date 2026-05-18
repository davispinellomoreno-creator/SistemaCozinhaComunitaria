package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.AlimentacaoDto;
import com.example.SistemaCozinhaComunitaria.Dto.ProdutoDto;
import com.example.SistemaCozinhaComunitaria.Entity.Alimentacao;
import com.example.SistemaCozinhaComunitaria.Entity.Produtos;
import com.example.SistemaCozinhaComunitaria.Repository.AlimentacaoRepository;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AlimentacaoService {

    private final AlimentacaoRepository alimentacaoRepository;

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository) {
        this.alimentacaoRepository = alimentacaoRepository;
    }

    public UUID save(AlimentacaoDto dto) {

        Alimentacao entity = new Alimentacao(
                UUID.randomUUID(),
                dto.alimentacao()
        );

        Alimentacao saved = alimentacaoRepository.save(entity);

        return saved.getId();
    }





