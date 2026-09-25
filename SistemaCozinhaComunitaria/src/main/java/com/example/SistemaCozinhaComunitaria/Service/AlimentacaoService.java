package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.AlimentacaoDto;
import com.example.SistemaCozinhaComunitaria.Entity.Alimentacao;
import com.example.SistemaCozinhaComunitaria.Entity.Usuario;
import com.example.SistemaCozinhaComunitaria.Enum.Perfil;
import com.example.SistemaCozinhaComunitaria.Exception.AcessoNegadoException;
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
        entity.setUsuario(usuarioLogado);

        Alimentacao saved = alimentacaoRepository.save(entity);

        return new AlimentacaoDto(
                saved.getId(),
                saved.getAlimentacao(),
                saved.getUsuario().getNome() // ✅ novo
        );
    }

    public List<AlimentacaoDto> findAll() {
        return alimentacaoRepository.findAll()
                .stream()
                .map(entity -> new AlimentacaoDto(
                        entity.getId(),
                        entity.getAlimentacao(),
                        entity.getUsuario() != null ? entity.getUsuario().getNome() : "—" // ✅ novo
                ))
                .toList();
    }

    public Alimentacao buscarAlimentacao(UUID id) {
        return alimentacaoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Alimentação não encontrada")
        );
    }
    public void deleteById(UUID id) {
        Usuario usuarioLogado = getUsuarioLogado();

        Alimentacao alimento = alimentacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alimentação não encontrada"));

        boolean ehDono = alimento.getUsuario() != null
                && alimento.getUsuario().getId().equals(usuarioLogado.getId());

        if (usuarioLogado.getPerfil() != Perfil.ADMIN && !ehDono) {
            throw new AcessoNegadoException("Você não tem permissão para excluir este item");
        }

        alimentacaoRepository.deleteById(id);
    }

    public Alimentacao atualizar(UUID id, AlimentacaoDto dto) {
        Alimentacao entity = alimentacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alimentação não encontrada"));

        entity.setAlimentacao(dto.alimentacao());

        return alimentacaoRepository.save(entity);
    }
}





