package com.desafio1.entities;

import com.desafio1.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(value = "id")
public class AutorDTO {

    private Long id;
    @NotEmpty(message = "O campo 'nome' nao pode ficar em branco ou nulo.")
    private String nome;
    @NotEmpty(message = "O campo e-mail nao pode ficar em branco, nem nulo.")
    @Email(message = "O campo 'e-mail' deve ser preenchido com um e-mail valido(Ex: xxxxxx@provedor.com).")
    @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Valor já existente no banco de dados.")
    private String email;
    @NotEmpty(message = "O campo 'descricao' nao pode ficar em branco ou nulo, e deve conter no maximo 400 caracteres.")
    @Size(min = 1, max = 400)
    private String descricao;

    public AutorDTO() {
    }

    public AutorDTO(Long id, String nome, String email, String descricao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public Autor createAutorWhithoutId() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setEmail(this.email);
        autor.setDescricao(this.descricao);
        return autor;
    }

    public Autor createAutorWhithId() {
        Autor autor = new Autor();
        autor.setId(this.id);
        autor.setNome(this.nome);
        autor.setEmail(this.email);
        autor.setDescricao(this.descricao);
        return autor;
    }
}
