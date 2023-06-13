package com.br.alura.forum.modelo.DTOs.resposta;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarResposta(
    
    @NotNull
    Long id, 
    @NotNull
    String mensagem,
    @NotNull 
    Boolean solucao) {
    
}
