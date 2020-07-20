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
 * @author Gabriel
 */
@Entity
public class Car implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String cor;
    private String placa;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true )
    @JoinColumn(name="client_id",referencedColumnName = "id", nullable=false)
    private Client client;

    public Car(String modelo, String cor, String placa, Client client) {
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.client = client;
    }
    public Car(String modelo, String cor, String placa) {
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
     
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
