package com.desafio1.entities;

import com.desafio1.validators.UniqueValue;

import javax.validation.constraints.NotEmpty;

public class CategoriaDto {

    @NotEmpty
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Valor já existente no banco de dados.")
    private String nome;

    public CategoriaDto() {
    }

    public CategoriaDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria createCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome(this.nome);
        return categoria;
    }
}
