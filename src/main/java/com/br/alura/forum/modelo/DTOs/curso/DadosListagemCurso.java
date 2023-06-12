package com.br.alura.forum.modelo.DTOs.curso;

import com.br.alura.forum.modelo.Curso;

public record DadosListagemCurso(Long id, String nome, String categoria) {
    
    public DadosListagemCurso(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
