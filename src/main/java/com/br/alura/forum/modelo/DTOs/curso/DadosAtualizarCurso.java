package com.br.alura.forum.modelo.DTOs.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCurso(

    @NotNull
    Long id,
    @NotNull
    String nome,
    @NotNull
    String categoria) {
    
}
