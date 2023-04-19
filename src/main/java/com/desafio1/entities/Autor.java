package com.desafio1.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "autor")
public class Autor {

    private final Instant instante = Instant.now();;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    // @Column(unique = true) Poderia ser usado para validar, mas foi implementado um validador na mao de exemplo
    private String email;
    private String descricao;

    public Autor() {
    }

    public Autor(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Instant getInstante() {
        return instante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "instante=" + instante +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
