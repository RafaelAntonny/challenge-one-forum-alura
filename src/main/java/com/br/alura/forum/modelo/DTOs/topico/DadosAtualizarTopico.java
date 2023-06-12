package com.br.alura.forum.modelo.DTOs.topico;

import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.DTOs.curso.DadosCurso;
import com.br.alura.forum.modelo.DTOs.usuario.DadosUsuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
    
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
