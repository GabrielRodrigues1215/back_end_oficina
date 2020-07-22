/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 *
 * @author Cast
 */
public class Estoque implements Serializable{
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Piece> piece;

    public Estoque() {
        //default
    }
    
    public Estoque(List<Piece> piece) {
        this.piece = piece;
    }
    
    

    public List<Piece> getPiece() {
        return piece;
    }

    public void setPiece(List<Piece> piece) {
        this.piece = piece;
    }
    
    
    
}
