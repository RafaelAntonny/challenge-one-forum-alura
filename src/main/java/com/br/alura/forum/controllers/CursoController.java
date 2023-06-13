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

import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.DTOs.curso.DadosAtualizarCurso;
import com.br.alura.forum.modelo.DTOs.curso.DadosCurso;
import com.br.alura.forum.modelo.DTOs.curso.DadosListagemCurso;
import com.br.alura.forum.repositories.CursoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCurso dados, UriComponentsBuilder uriBuilder) {
        var curso = new Curso(dados);
        repository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(String.valueOf(curso.getId())).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemCurso(curso));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemCurso>> listar() {
        var curso = repository.findAllTop10ByOrderByNomeAsc().stream().map(DadosListagemCurso::new).toList();

        return ResponseEntity.ok(curso);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Curso referenceById = repository.getReferenceById(id);
        var curso = referenceById;
        return ResponseEntity.ok(new DadosListagemCurso(curso));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarCurso dados) {
        var curso = repository.getReferenceById(dados.id());
        curso.atualizarCurso(dados);

        return ResponseEntity.ok(new DadosListagemCurso(curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
