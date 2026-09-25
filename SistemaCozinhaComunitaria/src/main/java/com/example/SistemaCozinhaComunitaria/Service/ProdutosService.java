package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.ProdutoDto;
import com.example.SistemaCozinhaComunitaria.Entity.Produtos;
import com.example.SistemaCozinhaComunitaria.Entity.Usuario;
import com.example.SistemaCozinhaComunitaria.Enum.Perfil;
import com.example.SistemaCozinhaComunitaria.Exception.AcessoNegadoException;
import com.example.SistemaCozinhaComunitaria.Exception.ResourceNotFoundException;
import com.example.SistemaCozinhaComunitaria.Repository.ProdutosRepository;
import com.example.SistemaCozinhaComunitaria.Repository.UsuarioRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutosService {

    private final ProdutosRepository repository;
    private final UsuarioRepository usuarioRepository;

    public ProdutosService(ProdutosRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    private Usuario getUsuarioLogado() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public UUID salvarProduto(@NotNull ProdutoDto produtodto) {
        Usuario usuarioLogado = getUsuarioLogado();

        var entity = Produtos.builder()
                .produto(produtodto.produtos())
                .validade(produtodto.validade())
                .quantidade(produtodto.quantidade())
                .usuario(usuarioLogado) // ✅ associa ao usuário logado
                .build();

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
                        entity.getQuantidade(),
                        entity.getUsuario() != null ? entity.getUsuario().getNome() : "—" // ✅ novo
                ))
                .toList();
    }

    public Produtos buscarProdutoPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Produto não encontrado!")
                );
    }

    public ResponseEntity<Void> deletarProdutoPorId(UUID id) {

        Usuario usuarioLogado = getUsuarioLogado();
        Produtos produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        boolean ehDono = produto.getUsuario() != null
                && produto.getUsuario().getId().equals(usuarioLogado.getId());
        if (usuarioLogado.getPerfil() != Perfil.ADMIN && !ehDono) {
            throw new AcessoNegadoException("Você não tem permissão para excluir este item");
        }

    repository.deleteById(id);
        return null;
    }

    public ProdutoDto atualizarProduto(UUID id, ProdutoDto produtodto) {
        Produtos entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado!"));

        entity.setProduto(produtodto.produtos());
        entity.setValidade(produtodto.validade());
        entity.setQuantidade(produtodto.quantidade());

        Produtos atualizar = repository.save(entity);

        return new ProdutoDto(
                atualizar.getId(),
                atualizar.getProduto(),
                atualizar.getValidade(),
                atualizar.getQuantidade(),
                atualizar.getUsuario() != null ? atualizar.getUsuario().getNome() : "—"
        );
    }
}





