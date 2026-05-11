package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.ProdutoDto;
import com.example.SistemaCozinhaComunitaria.Entity.Produtos;
import com.example.SistemaCozinhaComunitaria.Exception.ResourceNotFoundException;
import com.example.SistemaCozinhaComunitaria.Repository.ProdutosRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutosService {

    private final ProdutosRepository repository;

    public ProdutosService(ProdutosRepository repository) {
        this.repository = repository;
    }




    public UUID salvarProduto(@NotNull ProdutoDto produtodto) {

        var entity = new Produtos(
                UUID.randomUUID(),
                produtodto.produtos(),
                produtodto.validade(),
                produtodto.quantidade()
        );

        var produtoSalvo = repository.save(entity);

        return produtoSalvo.getId();
    }
    public List<ProdutoDto> findAll() {
        return repository.findAll()
                .stream()
                .map(entity -> new ProdutoDto(
                        entity.getId(),
                        entity.getProduto(),
                        entity.getValidade(),
                        entity.getQuantidade()
                ))
                .toList();
    }

    public Produtos buscarProdutoPorId (UUID id){
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Produto não encontrado!")
                );
    }
    public ResponseEntity<Void> deletarProdutoPorId(UUID id){

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");

        }
        repository.deleteById(id);

        return null;
    }
    public ProdutoDto atualizarProduto (UUID id,ProdutoDto produtodto){
        Produtos Entity = repository.findById(id)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Produto não encontrado!")

                );

        Entity.setProduto(produtodto.produtos());
        Entity.setValidade(produtodto.validade());
        Entity.setQuantidade(produtodto.quantidade());

        Produtos atualizar = repository.save(Entity);

        return new ProdutoDto(
                atualizar.getId(),
                atualizar.getProduto(),
                atualizar.getValidade(),
                atualizar.getQuantidade()
        );
    }
}





