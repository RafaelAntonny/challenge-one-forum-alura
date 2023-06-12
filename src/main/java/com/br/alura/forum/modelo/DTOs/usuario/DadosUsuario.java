package com.br.alura.forum.modelo.DTOs.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosUsuario(
    
    @NotNull
    long id,
    @NotNull
     String nome,
    @NotNull
    @Email
    String email,
    @NotNull 
    String senha) {
    
}
