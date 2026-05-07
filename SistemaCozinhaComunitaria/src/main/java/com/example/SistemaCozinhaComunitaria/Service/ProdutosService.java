package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Repository.ProdutosRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutosService {

    private final ProdutosRepository repository;



    public ProdutosService(ProdutosRepository repository) {
        this.repository = repository;
    }


}
