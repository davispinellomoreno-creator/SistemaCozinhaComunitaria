package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.AlimentacaoDto;
import com.example.SistemaCozinhaComunitaria.Entity.Alimentacao;
import com.example.SistemaCozinhaComunitaria.Entity.Usuario;
import com.example.SistemaCozinhaComunitaria.Enum.Perfil;
import com.example.SistemaCozinhaComunitaria.Exception.ResourceNotFoundException;
import com.example.SistemaCozinhaComunitaria.Repository.AlimentacaoRepository;
import com.example.SistemaCozinhaComunitaria.Repository.UsuarioRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlimentacaoService {

    private final AlimentacaoRepository alimentacaoRepository;
    private final UsuarioRepository usuarioRepository;

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository, UsuarioRepository usuarioRepository) {
        this.alimentacaoRepository = alimentacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    private Usuario getUsuarioLogado() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public AlimentacaoDto salvarAlimentacao(AlimentacaoDto dto) {
        Usuario usuarioLogado = getUsuarioLogado();

        Alimentacao entity = new Alimentacao();
        entity.setAlimentacao(dto.alimentacao());
        entity.setUsuario(usuarioLogado); // ✅ associa ao usuário logado

        Alimentacao saved = alimentacaoRepository.save(entity);

        return new AlimentacaoDto(
                saved.getId(),
                saved.getAlimentacao()
        );
    }

    public List<AlimentacaoDto> findAll() {
        Usuario usuarioLogado = getUsuarioLogado();

        List<Alimentacao> alimentacoes = usuarioLogado.getPerfil() == Perfil.ADMIN
                ? alimentacaoRepository.findAll()
                : alimentacaoRepository.findByUsuarioId(usuarioLogado.getId());

        return alimentacoes.stream()
                .map(entity -> new AlimentacaoDto(
                        entity.getId(),
                        entity.getAlimentacao()
                ))
                .toList();
    }

    public Alimentacao buscarAlimentacao(UUID id) {
        return alimentacaoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Alimentação não encontrada")
        );
    }

    public void deleteById(UUID id) {
        if (!alimentacaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Alimentação não encontrada");
        }
        alimentacaoRepository.deleteById(id);
    }

    public Alimentacao atualizar(UUID id, AlimentacaoDto dto) {
        Alimentacao entity = alimentacaoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Alimentação não encontrada"));

        entity.setAlimentacao(dto.alimentacao());

        Alimentacao alimentacaoAtualizada = alimentacaoRepository.save(entity);

        return alimentacaoAtualizada;
    }
}





