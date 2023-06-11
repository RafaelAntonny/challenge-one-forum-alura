package com.br.alura.forum.modelo.DTOs;

import java.time.LocalDate;

import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.Usuario;

import jakarta.validation.constraints.NotNull;

public record DadosTopico(
    @NotNull
    long id,
    @NotNull 
    String titulo,
    @NotNull 
    String mensagem,
    @NotNull 
    LocalDate dataCriacao,
    @NotNull 
    StatusTopico status,
    @NotNull 
    Usuario autor,
    @NotNull 
    Curso curso) {
    
}
