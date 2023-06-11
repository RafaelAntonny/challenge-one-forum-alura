package com.br.alura.forum.modelo.DTOs;

import java.time.LocalDate;

import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosResposta(
    @NotNull
    Long id, 
    @NotNull
    String mensagem,
    @NotNull
    @Valid 
    Topico topico,
    @NotNull
    LocalDate dataCriacao,
    @NotNull
    @Valid
    Usuario autor,
    @NotNull 
    Boolean solucao){
    
}
