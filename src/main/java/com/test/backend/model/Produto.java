package com.test.backend.model;

//#region Imports
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//#endregion

@Entity
public class Produto {

    //#region Atributos
    @Id //VAI TRANSFORMAR ESSA COLUNA EM PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id;
    private String nome;
    // O nome do produto
    private Integer quantidade;

    private String descricao;
       // A descrição do produto
    private Double valor;
    // O valor do produto
    private String observacao;
    // A observação do produto
    //#endregion

    //#region Construtores
    public Produto() {
        // Construtor padrão necessário para JPA
    }

    public Produto(String nome, Integer quantidade, String descricao, Double valor, String observacao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valor = valor;
        this.observacao = observacao;
    }
    //#endregion

    //#region Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDescricao() {
        return quantidade;
    }

    public void setDescricao(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    //#endregion

    //#region Métodos Adicionais
    @Override
    public String toString() {
        return "Produto{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", quantidade='" + quantidade + '\'' +
               ", valor=" + valor +
               ", observacao='" + observacao + '\'' +
               '}';
    }
    //#endregion

}