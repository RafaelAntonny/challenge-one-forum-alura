package com.br.alura.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.alura.forum.modelo.Resposta;
import com.br.alura.forum.modelo.DTOs.resposta.DadosAtualizarResposta;
import com.br.alura.forum.modelo.DTOs.resposta.DadosListagemResposta;
import com.br.alura.forum.modelo.DTOs.resposta.DadosResposta;
import com.br.alura.forum.repositories.RespostaRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/respostas")
public class RespostaController {
    
    @Autowired
    private RespostaRepository repository;

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemResposta> cadastrar(@RequestBody @Valid DadosResposta dados, UriComponentsBuilder uriBuilder) {
        var resposta = new Resposta(dados);
        repository.save(resposta);

        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(String.valueOf(resposta.getId())).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemResposta(resposta));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public ResponseEntity<List<DadosListagemResposta>> listar() {
        var resposta = repository.findAllTop10ByOrderByDataCriacaoAsc().stream().map(DadosListagemResposta::new).toList();

        return ResponseEntity.ok(resposta);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemResposta> detalhar(@PathVariable Long id) {
        Resposta referenceById = repository.getReferenceById(id);
        var resposta = referenceById;
        return ResponseEntity.ok(new DadosListagemResposta(resposta));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemResposta> atualizar(@RequestBody @Valid DadosAtualizarResposta dados) {
        var resposta = repository.getReferenceById(dados.id());
        resposta.atualizarResposta(dados);

        return ResponseEntity.ok(new DadosListagemResposta(resposta));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
