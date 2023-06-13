package com.br.alura.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import com.br.alura.forum.modelo.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    Streamable<Resposta> findAllTop10ByOrderByDataCriacaoAsc();
    
}
