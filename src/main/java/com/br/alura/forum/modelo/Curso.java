package com.br.alura.forum.modelo;

import com.br.alura.forum.modelo.DTOs.curso.DadosAtualizarCurso;
import com.br.alura.forum.modelo.DTOs.curso.DadosCurso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String categoria;

	public Curso(DadosCurso dados) {
		this.nome = dados.nome();
		this.categoria = dados.categoria();
	}

    public void atualizarCurso(DadosAtualizarCurso dados) {

		if (dados.nome() != null) {
			this.nome = dados.nome();	
		}
		
		if(dados.categoria() != null) {
			this.categoria = dados.categoria();
		}
    }
}
