package com.br.alura.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.DTOs.DadosCurso;
import com.br.alura.forum.repositories.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCurso dados) {
        repository.save(new Curso(dados));
    }
}
