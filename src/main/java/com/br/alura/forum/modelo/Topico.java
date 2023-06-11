package com.br.alura.forum.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.br.alura.forum.modelo.DTOs.DadosTopico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDate dataCriacao = LocalDate.now();

	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne
	private Usuario autor;

    @Embedded
	private Curso curso;
	private List<Resposta> respostas = new ArrayList<>();

	public Topico(DadosTopico dados) {
		this.titulo = dados.titulo();
		this.mensagem = dados.mensagem();
		this.dataCriacao = dados.dataCriacao();
		this.status = dados.status();
		this.autor = dados.autor();
		this.curso = dados.curso();
		this.respostas = dados.respostas();
	}
}
