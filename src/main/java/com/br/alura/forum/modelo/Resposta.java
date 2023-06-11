package com.br.alura.forum.modelo;

import java.time.LocalDate;

import com.br.alura.forum.modelo.DTOs.DadosResposta;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
	private Topico topico;
	private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
	private Usuario autor;
	private Boolean solucao = false;

	public Resposta(DadosResposta dados) {
		this.mensagem = dados.mensagem();
		this.topico = dados.topico();
		this.dataCriacao = dados.dataCriacao();
		this.autor = dados.autor();
		this.solucao = dados.solucao();
	}
}
