package com.example.SistemaCozinhaComunitaria.Service;

import com.example.SistemaCozinhaComunitaria.Dto.AlimentacaoDto;
import com.example.SistemaCozinhaComunitaria.Dto.ProdutoDto;
import com.example.SistemaCozinhaComunitaria.Entity.Alimentacao;
import com.example.SistemaCozinhaComunitaria.Entity.Produtos;
import com.example.SistemaCozinhaComunitaria.Exception.ResourceNotFoundException;
import com.example.SistemaCozinhaComunitaria.Repository.AlimentacaoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

@Service
public class AlimentacaoService {

    private final AlimentacaoRepository alimentacaoRepository;

    public AlimentacaoService(AlimentacaoRepository alimentacaoRepository) {
        this.alimentacaoRepository = alimentacaoRepository;
    }

    public AlimentacaoDto salvarAlimentacao(AlimentacaoDto dto) {  // ✅ tipo de retorno = AlimentacaoDto
        Alimentacao entity = new Alimentacao();
        entity.setAlimentacao(dto.alimentacao());

        Alimentacao saved = alimentacaoRepository.save(entity);

        return new AlimentacaoDto(
                saved.getId(),
                saved.getAlimentacao()
        );
    }
    
    public List<AlimentacaoDto>findAll() {
        return alimentacaoRepository.findAll()
                .stream()
                .map(entity -> new AlimentacaoDto(
                        entity.getId(),
                        entity.getAlimentacao()
                ))
                .toList();
    }

    public Alimentacao buscarAlimentacao(UUID id){
        return alimentacaoRepository.findById(id).orElseThrow(

                ()-> new ResourceNotFoundException("Alimentação não encontrada")
        );

    }

    public void deleteById(UUID id) {

        if (!alimentacaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado");
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





