package com.example.SistemaCozinhaComunitaria.Controller;

import com.example.SistemaCozinhaComunitaria.Dto.AlimentacaoDto;
import com.example.SistemaCozinhaComunitaria.Dto.UsuarioDto;
import com.example.SistemaCozinhaComunitaria.Entity.Usuario;
import com.example.SistemaCozinhaComunitaria.Service.AlimentacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alimentacao")
public class AlimentaçãoController {

    private final AlimentacaoService alimentacaoService;

    public AlimentaçãoController(AlimentacaoService alimentacaoService) {
        this.alimentacaoService = alimentacaoService;
    }
    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody AlimentacaoDto alimentacaoDto) {
        UUID id = alimentacaoService.salvarAlimentacao(alimentacaoDto);

        URI location = URI.create("/usuarios/" + id);

        return ResponseEntity
                .created(location)
                .body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarProduto(@PathVariable UUID id) {
        return ResponseEntity.ok(alimentacaoService.buscarAlimentacao(id).getUsuario());
    }
    @GetMapping
    public ResponseEntity<List<AlimentacaoDto>> findAll() {
        List<AlimentacaoDto> produtos = alimentacaoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarProdutos (@PathVariable UUID id, @RequestBody AlimentacaoDto alimentacaoDto){

        Usuario atualizar = alimentacaoService.atualizar(id, alimentacaoDto).getUsuario();
        return ResponseEntity.ok(atualizar);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        alimentacaoService.deleteById(id);
    }
}
