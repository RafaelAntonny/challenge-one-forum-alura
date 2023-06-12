package com.br.alura.forum.modelo.DTOs.resposta;

import java.time.LocalDate;

import com.br.alura.forum.modelo.Resposta;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;

public record DadosListagemResposta(String mensagem, Topico topico, LocalDate dataCriacao, Usuario autor, Boolean solucao) {
   
    public DadosListagemResposta(Resposta resposta) {
        this(resposta.getMensagem(), resposta.getTopico(), resposta.getDataCriacao(), resposta.getAutor(), resposta.getSolucao());
    }
}
