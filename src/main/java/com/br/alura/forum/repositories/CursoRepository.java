package com.br.alura.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import com.br.alura.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Streamable<Curso> findAllTop10ByOrderByNomeAsc();
    
}
