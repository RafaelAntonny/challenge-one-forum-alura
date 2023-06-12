package com.br.alura.forum.modelo;

import com.br.alura.forum.modelo.DTOs.usuario.DadosAtualizarUsuario;
import com.br.alura.forum.modelo.DTOs.usuario.DadosUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(DadosUsuario dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void atualizarUsuario(DadosAtualizarUsuario dados) {
        this.nome = dados.nome();
        this.nome = dados.email();
        this.nome = dados.senha();
    }
}
