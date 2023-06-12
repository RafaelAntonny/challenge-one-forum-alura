package com.br.alura.forum.modelo.DTOs.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCurso(

    @NotNull
    long id,
    @NotNull
    String nome,
    @NotNull
    String categoria) {
    
}
