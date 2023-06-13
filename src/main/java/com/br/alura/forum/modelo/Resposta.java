package com.br.alura.forum.modelo;

import java.time.LocalDate;

import com.br.alura.forum.modelo.DTOs.resposta.DadosAtualizarResposta;
import com.br.alura.forum.modelo.DTOs.resposta.DadosResposta;

import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "topico_id")
	private Topico topico;
	private LocalDate dataCriacao = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "autor_id")
	private Usuario autor;
	private Boolean solucao = false;

	public Resposta(DadosResposta dados) {
		this.mensagem = dados.mensagem();
		this.topico = new Topico(dados.topico());
		this.dataCriacao = dados.dataCriacao();
		this.autor = new Usuario(dados.autor());
		this.solucao = dados.solucao();
	}

    public void atualizarResposta(DadosAtualizarResposta dados) {

		if (dados.mensagem() != null) {
			this.mensagem = dados.mensagem();
		}
		if (dados.solucao() != null) {
			this.solucao = dados.solucao();
		}
    }
}
