package com.br.alura.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.DTOs.DadosTopico;
import com.br.alura.forum.repositories.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    
    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosTopico dados) {
        repository.save(new Topico(dados));
    }

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }
}
