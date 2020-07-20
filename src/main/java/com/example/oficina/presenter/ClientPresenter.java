/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.presenter;

import com.example.oficina.models.Car;
import com.example.oficina.models.Client;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gabriel
 */
public class ClientPresenter {

    private Long id;
    private String name;
    private String cpf;
    private String rua;
    private Long numero;
    private String bairro;
    private String email;
    private List<CarPresenter> cars;

    public ClientPresenter(Client client) {
        if (client != null) {
            this.id = client.getId();
            this.name = client.getName();
            this.cpf = client.getCpf();
            this.email = client.getEmail();
            this.bairro = client.getBairro();
            this.numero = client.getNumero();
            this.rua = client.getRua();
            if (client.getCars() != null) {
                this.cars = client.getCars().stream().map(CarPresenter::new).collect(Collectors.toList());
            }

        }

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRua() {
        return rua;
    }

    public Long getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEmail() {
        return email;
    }

    public List<CarPresenter> getCars() {
        return cars;
    }

    public static List<ClientPresenter> listFromClients(List<Client> client) {
        return client.stream()
                .map(ClientPresenter::new)
                .collect(Collectors.toList());
    }

}
