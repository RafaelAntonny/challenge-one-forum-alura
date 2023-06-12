package com.br.alura.forum.modelo.DTOs.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(
    
    @NotNull
    Long id,
    @NotNull
    String nome,
    @NotNull
    @Email
    String email,
    @NotNull 
    String senha) {
    
}
