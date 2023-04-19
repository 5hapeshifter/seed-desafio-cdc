package com.desafio1.controllers;

import com.desafio1.entities.Categoria;
import com.desafio1.entities.CategoriaDto;
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
@RequestMapping(path = "/categorias")
public class CategoriasController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> criar(@RequestBody @Valid CategoriaDto categoriaDto) {

        Categoria categoria = categoriaDto.createCategoria();
        entityManager.persist(categoria);
        return ResponseEntity.ok(categoriaDto);
    }

}
