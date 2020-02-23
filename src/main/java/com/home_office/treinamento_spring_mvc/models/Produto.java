package com.home_office.treinamento_spring_mvc.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;



// indica que a classe vai virar uma tabela
@Entity
public class Produto{
    
    //indica que o atributo em questão é a chave primária.
    @Id
    //indica a maneira como vai ser gerada a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    private String title;
    // indica que o atributo em questão vai ser salvo como Clob ou Blob no banco de dados.
    @Lob
    private String description;
    private int pages;

    @ElementCollection
    private List<Preco> precos = new ArrayList<Preco>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Preco> getPrecos() {
        return precos;
    }

    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }
    
}