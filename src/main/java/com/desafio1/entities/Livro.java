package com.desafio1.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroDePaginas;
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataDePublicacao;
    private Long idCategoria;
    private Long idAutor;

    public Livro() {
    }

    public Livro(BuilderLivro builderLivro) {
        this.titulo = builderLivro.titulo;
        this.resumo = builderLivro.resumo;
        this.sumario = builderLivro.sumario;
        this.preco = builderLivro.preco;
        this.numeroDePaginas = builderLivro.numeroDePaginas;
        this.isbn = builderLivro.isbn;
        this.dataDePublicacao = builderLivro.dataDePublicacao;
        this.idCategoria = builderLivro.idCategoria;
        this.idAutor = builderLivro.idAutor;
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

    public static class BuilderLivro {

        private String titulo;
        private String resumo;
        private String sumario;
        private BigDecimal preco;
        private Integer numeroDePaginas;
        private String isbn;
        private LocalDate dataDePublicacao;
        private Long idCategoria;
        private Long idAutor;

        public static BuilderLivro newInstance() {
            return new BuilderLivro();
        }

        private BuilderLivro() {

        }

        public BuilderLivro setTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public BuilderLivro setResumo(String resumo) {
            this.resumo = resumo;
            return this;
        }

        public BuilderLivro setSumario(String sumario) {
            this.sumario = sumario;
            return this;
        }

        public BuilderLivro setPreco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public BuilderLivro setNumeroDePaginas(Integer numeroDePaginas) {
            this.numeroDePaginas = numeroDePaginas;
            return this;
        }

        public BuilderLivro setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BuilderLivro setDataDePublicacao(LocalDate dataDePublicacao) {
            this.dataDePublicacao = dataDePublicacao;
            return this;
        }

        public BuilderLivro setIdCategoria(Long idCategoria) {
            this.idCategoria = idCategoria;
            return this;
        }

        public BuilderLivro setIdAutor(Long idAutor) {
            this.idAutor = idAutor;
            return this;
        }

        public Livro build() {
            return new Livro(this);
        }

    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroDePaginas=" + numeroDePaginas +
                ", isbn='" + isbn + '\'' +
                ", dataDePublicacao=" + dataDePublicacao +
                ", categoria='" + idCategoria + '\'' +
                ", autor=" + idAutor +
                '}';
    }
}
