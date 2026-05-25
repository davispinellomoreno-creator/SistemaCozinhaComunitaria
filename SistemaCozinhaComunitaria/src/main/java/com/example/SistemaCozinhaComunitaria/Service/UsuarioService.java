package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.UsuarioDto;
import com.example.SistemaCozinhaComunitaria.Entity.Usuario;
import com.example.SistemaCozinhaComunitaria.Exception.ResourceNotFoundException;
import com.example.SistemaCozinhaComunitaria.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(UsuarioDto usuarioDto) {

        Usuario entity = new Usuario(
                UUID.randomUUID(),
                usuarioDto.nome(),
                usuarioDto.email(),
                usuarioDto.senha(),
                usuarioDto.ativo()
        );

        return usuarioRepository.save(entity);
    }
    public List<UsuarioDto> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(entity -> new UsuarioDto(
                        entity.getId(),
                        entity.getNome(),
                        entity.getEmail(),
                        entity.getSenha(),
                        entity.getAtivo()
                ))
                .toList();
    }
    public Usuario buscarUsuario(UUID id){
        return usuarioRepository.findById(id).orElseThrow(

                ()-> new ResourceNotFoundException("Alimentação não encontrada")
        );

    }

    public void deleteById(UUID id) {

        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        usuarioRepository.deleteById(id);
    }
    public Usuario atualizar(UUID id, UsuarioDto dto) {


        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Alimentação não encontrada"));

        entity.setNome(dto.nome());


        Usuario usuarioAtualizada = usuarioRepository.save(entity);


        return usuarioAtualizada;
    }


}
