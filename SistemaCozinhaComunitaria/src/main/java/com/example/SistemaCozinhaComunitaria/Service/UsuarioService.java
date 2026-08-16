package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.UsuarioDto;
import com.example.SistemaCozinhaComunitaria.Dto.UsuarioListagemDto;
import com.example.SistemaCozinhaComunitaria.Entity.Usuario;
import com.example.SistemaCozinhaComunitaria.Enum.Perfil;
import com.example.SistemaCozinhaComunitaria.Exception.ResourceNotFoundException;
import com.example.SistemaCozinhaComunitaria.Repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario salvar(UsuarioDto usuarioDto) {

        Usuario entity = Usuario.builder()
                .nome(usuarioDto.nome())
                .email(usuarioDto.email())
                .senha(passwordEncoder.encode(usuarioDto.senha()))
                .ativo(usuarioDto.ativo())
                .perfil(Perfil.USER)
                .build(); // ✅ sem .id(...) — o Hibernate gera sozinho

        return usuarioRepository.save(entity);
    }

    public List<UsuarioListagemDto> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(entity -> new UsuarioListagemDto(
                        entity.getId(),
                        entity.getNome(),
                        entity.getEmail(),
                        entity.getAtivo(),
                        entity.getPerfil()
                ))
                .toList();
    }

    public Usuario buscarUsuario(UUID id){
        return usuarioRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Alimentação não encontrada")
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

        return usuarioRepository.save(entity);
    }
    public Usuario atualizarPerfil (UUID id, Perfil novoPerfil){
        Usuario entity = usuarioRepository.findById(id)
                .orElseThrow(()->
                        new ResourceNotFoundException("Usuário não encontrado"));

        entity.setPerfil(novoPerfil);

        return usuarioRepository.save(entity);
    }
}