/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.presenter;

import com.example.oficina.converter.ConverterPresenter;
import com.example.oficina.models.Orcamento;
import com.example.oficina.models.Piece;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Cast
 */
public class PiecePresenter {
    
    private Long id;
    private String name;
    private String descricao;
    private Double preço;
    private Long qtdPiece;
    private OrcPresenter orcamento;

    public PiecePresenter(Piece piece) {
        this.id = piece.getId();
        this.name = piece.getName();
        this.descricao = piece.getDescricao();
        this.preço = piece.getPreco();
        this.qtdPiece = piece.getQtdPiece();
        if(piece.getOrcamento() != null){
            this.orcamento = ConverterPresenter.convertOrcPresenter(piece.getOrcamento());
        }
        
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreço() {
        return preço;
    }

    public Long getQtdPiece() {
        return qtdPiece;
    }

    public OrcPresenter getOrcamento() {
        return orcamento;
    }
    
    
    
    
}

