package com.example.SistemaCozinhaComunitaria.Controller;

import com.example.SistemaCozinhaComunitaria.Dto.AtualizarPerfilDto;
import com.example.SistemaCozinhaComunitaria.Dto.UsuarioDto;
import com.example.SistemaCozinhaComunitaria.Dto.UsuarioListagemDto;
import com.example.SistemaCozinhaComunitaria.Entity.Usuario;
import com.example.SistemaCozinhaComunitaria.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody UsuarioDto usuarioDto) {
        UUID id = usuarioService.salvar(usuarioDto).getId();

        URI location = URI.create("/usuarios/" + id);

        return ResponseEntity
                .created(location)
                .body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarProduto(@PathVariable UUID id) {
        return ResponseEntity.ok(usuarioService.buscarUsuario(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioListagemDto>> findAll() {
        List<UsuarioListagemDto> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarProdutos(@PathVariable UUID id, @RequestBody UsuarioDto usuarioDto) {
        Usuario atualizar = usuarioService.atualizar(id, usuarioDto);
        return ResponseEntity.ok(atualizar);
    }


    @PatchMapping("/{id}/perfil")
    public ResponseEntity<Usuario> atualizarPerfil(
            @PathVariable UUID id,
            @RequestBody AtualizarPerfilDto dto
    ) {
        Usuario atualizado = usuarioService.atualizarPerfil(id, dto.perfil());
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        usuarioService.deleteById(id);
    }
}

