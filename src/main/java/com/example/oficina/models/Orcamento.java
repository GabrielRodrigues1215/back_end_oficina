/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Cast
 */
@Entity
public class Orcamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dtOrcamento;
    private Double precoMaoDeObra;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Func funcionario;

    @OneToMany(fetch = FetchType.LAZY )
    @JoinColumn(name="piece_id",referencedColumnName = "id", nullable=false)
    private List<Piece> piece;

    public Orcamento(Date dtOrcamento, Double precoMaoDeObra, Func funcionario, List<Piece> piece) {
        this.dtOrcamento = dtOrcamento;
        this.precoMaoDeObra = precoMaoDeObra;
        this.funcionario = funcionario;
        this.piece = piece;
    }

    public Orcamento(Date dtOrcamento, Double precoMaoDeObra, List<Piece> piece) {
        this.dtOrcamento = dtOrcamento;
        this.precoMaoDeObra = precoMaoDeObra;
        this.piece = piece;
    }

    public Orcamento() {
        //default
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtOrcamento() {
        return dtOrcamento;
    }

    public void setDtOrcamento(Date dtOrcamento) {
        this.dtOrcamento = dtOrcamento;
    }

    public Double getPrecoMaoDeObra() {
        return precoMaoDeObra;
    }

    public void setPrecoMaoDeObra(Double precoMaoDeObra) {
        this.precoMaoDeObra = precoMaoDeObra;
    }

    public Func getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Func funcionario) {
        this.funcionario = funcionario;
    }

    public List<Piece> getPiece() {
        return piece;
    }

    public void setPiece(List<Piece> piece) {
        this.piece = piece;
    }
    
    

}
