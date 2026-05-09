package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.ProdutoDto;
import com.example.SistemaCozinhaComunitaria.Entity.Produtos;
import com.example.SistemaCozinhaComunitaria.Repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProdutosService {

    private final ProdutosRepository repository;

    public ProdutosService(ProdutosRepository repository) {
        this.repository = repository;
    }

    public UUID SalvarProduto(ProdutoDto produtodto) {

 var Entity = new Produtos(
         UUID.randomUUID(),
         produtodto.produtos(),
         produtodto.validade());

 var produtosSaved = repository.save(Entity);

return produtosSaved.getId();


    }

}





