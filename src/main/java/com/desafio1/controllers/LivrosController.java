package com.desafio1.controllers;

import com.desafio1.entities.Livro;
import com.desafio1.entities.LivroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/livros")
public class LivrosController {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    public ResponseEntity<LivroDTO> createLivro(@RequestBody @Valid LivroDTO livroDTO) {
        Livro livro = livroDTO.createLivro();
        manager.persist(livro);
        return ResponseEntity.ok(livroDTO);
    }

}
