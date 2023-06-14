package com.br.alura.forum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.alura.forum.modelo.Usuario;
import com.br.alura.forum.modelo.DTOs.usuario.DadosAtualizarUsuario;
import com.br.alura.forum.modelo.DTOs.usuario.DadosCadastrarUsuario;
import com.br.alura.forum.modelo.DTOs.usuario.DadosListagemUsuario;
import com.br.alura.forum.repositories.UsuarioRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemUsuario> cadastrar(@RequestBody @Valid DadosCadastrarUsuario dados, UriComponentsBuilder uriBuilder) {
        String encodedPassword = passwordEncoder.encode(dados.senha());

        var usuario = new Usuario(null, dados.nome(), dados.email(), encodedPassword);

        repository.save(usuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(String.valueOf(usuario.getId())).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemUsuario(usuario));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public ResponseEntity<List<DadosListagemUsuario>> listar() {
        var topico = repository.findAllTop10ByOrderByNomeAsc().stream().map(DadosListagemUsuario::new).toList();

        return ResponseEntity.ok(topico);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemUsuario> detalhar(@PathVariable Long id) {
        Usuario referenceById = repository.getReferenceById(id);
        var usuario = referenceById;
        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemUsuario> atualizar(@RequestBody @Valid DadosAtualizarUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarUsuario(dados);

        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
