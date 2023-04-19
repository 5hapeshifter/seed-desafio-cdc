package com.desafio1.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDTO {

    @NotEmpty(message = "O titulo deve ser preenchido.")
    private String titulo;
    @NotEmpty(message = "O resumo deve ser preenchido com no maximo 500 caracteres.")
    @Size(max = 500)
    private String resumo;
    @NotEmpty
    private String sumario;
    @NotEmpty
    @Min(value = 20, message = "O valor minimo do livro e de R$ 20 reais.")
    private BigDecimal preco;
    @NotEmpty
    @Min(value = 100, message = "A quantidade minima de paginas do livro e de 100.")
    private Integer numeroDePaginas;
    @Column(unique = true)
    @NotEmpty
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;
    @NotEmpty
    private Long idCategoria;
    @NotNull
    private Long idAutor;

    public LivroDTO() {
    }

    public LivroDTO(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas, String isbn, LocalDate dataDePublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public Livro createLivro() {
        return Livro.BuilderLivro.newInstance()
                .setTitulo(this.titulo)
                .setResumo(this.resumo)
                .setSumario(this.sumario)
                .setPreco(this.preco)
                .setNumeroDePaginas(this.numeroDePaginas)
                .setIsbn(this.isbn)
                .setDataDePublicacao(this.dataDePublicacao)
                .setIdCategoria(this.idCategoria)
                .setIdAutor(idAutor)
                .build();
    }

}
