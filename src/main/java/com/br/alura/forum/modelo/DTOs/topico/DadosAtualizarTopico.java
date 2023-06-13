package com.br.alura.forum.modelo.DTOs.topico;

import com.br.alura.forum.modelo.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
    
    @NotNull
    Long id,
    @NotNull 
    String titulo,
    @NotNull 
    String mensagem,
    @NotNull 
    StatusTopico status) {
    
}
