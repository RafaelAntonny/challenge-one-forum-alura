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

import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.DTOs.topico.DadosAtualizarTopico;
import com.br.alura.forum.modelo.DTOs.topico.DadosListagemTopico;
import com.br.alura.forum.modelo.DTOs.topico.DadosNovoTopico;
import com.br.alura.forum.repositories.TopicoRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    
    @Autowired
    private TopicoRepository repository;

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemTopico> cadastrar(@RequestBody @Valid DadosNovoTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemTopico(topico));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public ResponseEntity<List<DadosListagemTopico>> listar() {
        var topico = repository.findAllTop10ByOrderByDataCriacaoAsc().stream().map(DadosListagemTopico::new).toList();

        return ResponseEntity.ok(topico);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/curso/{nome}")
    public ResponseEntity<List<DadosListagemTopico>> listarPorCursoNome(@PathVariable String nome) {
        var topico = repository.findAllTop10ByCursoNomeOrderByDataCriacaoAsc(nome).stream().map(DadosListagemTopico::new).toList();

        return ResponseEntity.ok(topico);
    }    

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemTopico> detalhar(@PathVariable Long id) {
        Topico referenceById = repository.getReferenceById(id);
        var topico = referenceById;
        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemTopico> atualizar(@RequestBody @Valid DadosAtualizarTopico dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarTopico(dados);

        return ResponseEntity.ok(new DadosListagemTopico(topico));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
