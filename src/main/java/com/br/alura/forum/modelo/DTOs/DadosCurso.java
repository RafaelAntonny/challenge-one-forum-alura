package com.br.alura.forum.modelo.DTOs;

import jakarta.validation.constraints.NotNull;

public record DadosCurso(
    @NotNull
    long id,
    @NotNull
    String nome,
    @NotNull
    String categoria) {
    
}
