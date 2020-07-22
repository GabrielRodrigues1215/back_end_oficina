/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.presenter;

import com.example.oficina.converter.ConverterPresenter;
import com.example.oficina.models.Orcamento;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Cast
 */
public class OrcPresenter {

    private Long id;
    private Date dtOrcamento;
    private Double precoMaoDeObra;
    private FuncPresenter funcionario;
    private List<PiecePresenter> piece;

    public OrcPresenter(Orcamento orc) {
        this.id = orc.getId();
        this.dtOrcamento = orc.getDtOrcamento();
        this.precoMaoDeObra = orc.getPrecoMaoDeObra();
        if(orc.getFuncionario() != null){
            this.funcionario = ConverterPresenter.convertFuncPresenter(orc.getFuncionario());
        }
        if(orc.getPiece() != null){
            this.piece = orc.getPiece().stream().map(PiecePresenter::new).collect(Collectors.toList());

        }
    }

    public Long getId() {
        return id;
    }

    public Date getDtOrcamento() {
        return dtOrcamento;
    }

    public Double getPrecoMaoDeObra() {
        return precoMaoDeObra;
    }

    public FuncPresenter getFuncionario() {
        return funcionario;
    }

    public List<PiecePresenter> getPiece() {
        return piece;
    }
    
    
    

}
