package com.br.alura.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.alura.forum.modelo.Usuario;
import com.br.alura.forum.modelo.DTOs.DadosUsuario;
import com.br.alura.forum.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosUsuario dados) {
        repository.save(new Usuario(dados));
    }
}
