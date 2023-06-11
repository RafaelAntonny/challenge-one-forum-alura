package com.br.alura.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.alura.forum.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
