/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.presenter;

import com.example.oficina.models.Car;

/**
 *
 * @author Gabriel
 */
public class CarPresenter {

    private Long id;
    private String modelo;
    private String cor;
    private String placa;

    public CarPresenter(Car car) {
        this.id = car.getId();
        this.modelo = car.getModelo();
        this.cor = car.getCor();
        this.placa = car.getPlaca();
    }

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getPlaca() {
        return placa;
    }

}
