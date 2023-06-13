package com.br.alura.forum.modelo.DTOs.resposta;

import java.time.LocalDate;

import com.br.alura.forum.modelo.DTOs.topico.DadosNovoTopico;
import com.br.alura.forum.modelo.DTOs.usuario.DadosUsuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosResposta( 
    @NotNull
    String mensagem,
    @NotNull
    @Valid 
    DadosNovoTopico topico,
    @NotNull
    LocalDate dataCriacao,
    @NotNull
    @Valid
    DadosUsuario autor,
    @NotNull 
    Boolean solucao){
    
}
