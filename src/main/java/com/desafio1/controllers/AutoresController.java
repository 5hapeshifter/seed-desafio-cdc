package com.desafio1.controllers;

import com.desafio1.entities.Autor;
import com.desafio1.entities.AutorDTO;
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
@RequestMapping("/autores")
public class AutoresController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDTO> cadastrarAutores(@RequestBody @Valid AutorDTO autorDTO) {
        Autor autor = autorDTO.createAutor();
        entityManager.persist(autor);
        return ResponseEntity.ok(autorDTO);
    }


}
