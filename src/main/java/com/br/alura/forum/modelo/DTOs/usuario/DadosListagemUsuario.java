package com.br.alura.forum.modelo.DTOs.usuario;

import com.br.alura.forum.modelo.Usuario;

public record DadosListagemUsuario(Long id, String nome, String email, String senha) {
    
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
