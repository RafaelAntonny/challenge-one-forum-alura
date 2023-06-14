package com.br.alura.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.alura.forum.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Streamable<Usuario> findAllTop10ByOrderByNomeAsc();

    UserDetails findByEmail(String username);
    
}
