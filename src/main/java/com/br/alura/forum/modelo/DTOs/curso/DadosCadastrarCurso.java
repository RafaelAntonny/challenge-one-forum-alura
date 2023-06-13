package com.br.alura.forum.modelo.DTOs.curso;

import jakarta.validation.constraints.NotNull;

public record DadosCadastrarCurso(
    @NotNull
    String nome,
    @NotNull
    String categoria) {
}
