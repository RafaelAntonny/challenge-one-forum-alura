package com.br.alura.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.alura.forum.modelo.Resposta;
import com.br.alura.forum.modelo.DTOs.DadosResposta;
import com.br.alura.forum.repositories.RespostaRepository;

@RestController
@RequestMapping("/respostas")
public class RespostaController {
    
    @Autowired
    private RespostaRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosResposta dados) {
        repository.save(new Resposta(dados));
    }

    @GetMapping
    public List<Resposta> listar() {
        return repository.findAll();
    }
}
