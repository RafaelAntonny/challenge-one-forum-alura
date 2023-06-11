package com.br.alura.forum.modelo.DTOs.topico;

import java.time.LocalDate;
import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;

public record DadosListagemTopico(String titulo, String mensagem, LocalDate dataCriacao, StatusTopico status, Usuario autor, Curso curso) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
