package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Repository.AlimentacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlimentacaoService {

    private final AlimentacaoRepository alimentacaoRepository;

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository){
        this.alimentacaoRepository = alimentacaoRepository;
    }

}
