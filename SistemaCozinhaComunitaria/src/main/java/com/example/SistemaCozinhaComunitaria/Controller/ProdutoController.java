package com.example.SistemaCozinhaComunitaria.Controller;

import com.example.SistemaCozinhaComunitaria.Dto.ProdutoDto;
import com.example.SistemaCozinhaComunitaria.Entity.Produtos;
import com.example.SistemaCozinhaComunitaria.Service.ProdutosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Produtos")
public class ProdutoController {


    private final ProdutosService produtoservice;

    public ProdutoController(ProdutosService produtoservice) {
        this.produtoservice = produtoservice;
    }

    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody  ProdutoDto produtos) {
        UUID id = produtoservice.salvarProduto(produtos);

        URI location = URI.create("/produtos/" + id);

        return ResponseEntity
                .created(location)
                .body(id);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarProduto(@PathVariable UUID id) {
        return ResponseEntity.ok(produtoservice.buscarProdutoPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<ProdutoDto>> findAll() {
        List<ProdutoDto> produtos = produtoservice.findAll();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping
    public ResponseEntity<ProdutoDto> atualizarProdutos (@PathVariable UUID id, @RequestBody ProdutoDto produtos){

        ProdutoDto atualizar = produtoservice.atualizarProduto(id, produtos);
        return ResponseEntity.ok(atualizar);

    }
   
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        produtoservice.deletarProdutoPorId(id);
    }


}
