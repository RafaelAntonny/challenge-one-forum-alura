package com.br.alura.forum.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.br.alura.forum.modelo.DTOs.topico.DadosAtualizarTopico;
import com.br.alura.forum.modelo.DTOs.topico.DadosNovoTopico;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@JoinColumn(name = "usuario_id")
	private Usuario autor;

    @ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@OneToMany(mappedBy = "topico")
	private List<Resposta> respostas = new ArrayList<>();

	public Topico(DadosNovoTopico dados) {
		this.titulo = dados.titulo();
		this.mensagem = dados.mensagem();
		this.dataCriacao = LocalDate.now();
		this.status = dados.status();
		this.autor = new Usuario(dados.autor());
		this.curso = new Curso(dados.curso());
	}

	public void atualizarTopico(DadosAtualizarTopico dados) {
		if (dados.titulo() != null) {
			this.titulo = dados.titulo();
		}
		if (dados.mensagem() != null) {
			this.mensagem = dados.mensagem();
		}
		if (dados.status() != null) {
			this.status = dados.status();
		}
	}
}
