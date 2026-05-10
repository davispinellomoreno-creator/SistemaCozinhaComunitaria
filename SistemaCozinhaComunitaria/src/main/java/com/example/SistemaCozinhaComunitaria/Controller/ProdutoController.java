package com.example.SistemaCozinhaComunitaria.Controller;

import com.example.SistemaCozinhaComunitaria.Entity.Produtos;
import com.example.SistemaCozinhaComunitaria.Service.ProdutosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Produtos")
public class ProdutoController {


    private final ProdutosService produtoservice;

    public ProdutoController(ProdutosService produtoservice) {
        this.produtoservice = produtoservice;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarProduto(@PathVariable UUID id) {
        return ResponseEntity.ok(produtoservice.buscarProdutoPorId(id));
    }


}
