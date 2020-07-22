/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Cast
 */
@Entity
public class Piece implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;
    private Double preco;
    private Long qtdPiece;
    
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="orcamento_id",referencedColumnName = "id", nullable=false)
    private Orcamento orcamento;


    public Piece(String name, String descricao, Double preco, Long qtdPiece) {
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdPiece = qtdPiece;
    }
    public Piece(String name, String descricao, Double preco, Long qtdPiece, Orcamento orcamento) {
        this.name = name;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdPiece = qtdPiece;
        this.orcamento = orcamento;
    }

    
    
    
    public Piece() {
        //default
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getQtdPiece() {
        return qtdPiece;
    }

    public void setQtdPiece(Long qtdPiece) {
        this.qtdPiece = qtdPiece;
    }
    
    
    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }
    
    
}
