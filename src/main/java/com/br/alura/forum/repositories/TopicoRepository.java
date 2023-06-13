package com.br.alura.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

import com.br.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Streamable<Topico> findAllTop10ByOrderByDataCriacaoAsc();

    @Query("from Topico t inner join fetch t.curso where t.curso.nome = :nome")
    Streamable<Topico> findAllTop10ByCursoNomeOrderByDataCriacaoAsc(@Param("nome") String nome);
    
}
