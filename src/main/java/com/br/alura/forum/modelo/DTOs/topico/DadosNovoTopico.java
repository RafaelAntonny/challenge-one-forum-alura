package com.br.alura.forum.modelo.DTOs.topico;

import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.DTOs.DadosCurso;
import com.br.alura.forum.modelo.DTOs.DadosUsuario;

import jakarta.validation.constraints.NotNull;

public record DadosNovoTopico(

    @NotNull
    long id,
    @NotNull 
    String titulo,
    @NotNull 
    String mensagem,
    @NotNull 
    StatusTopico status,
    @NotNull 
    DadosUsuario autor,
    @NotNull 
    DadosCurso curso) {    
}
