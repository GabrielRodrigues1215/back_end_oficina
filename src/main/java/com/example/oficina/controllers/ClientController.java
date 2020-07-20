/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.controllers;

import com.example.oficina.models.Car;
import com.example.oficina.models.Client;
import com.example.oficina.presenter.ClientPresenter;
import com.example.oficina.repository.ClientRepository;
import java.net.URI;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Gabriel
 */
@RestController
@RequestMapping("v1/client")
public class ClientController {

    @Autowired
    public ClientRepository clientRepository;
//    @Autowired
//    public CarRepository carRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientPresenter> createClient(@PathParam(value = "name") String name,
            @PathParam(value = "cpf") String cpf,
            @PathParam(value = "email") String email,
            @PathParam(value = "rua") String rua,
            @PathParam(value = "bairro") String bairro,
            @PathParam(value = "numero") Long numero,
            @RequestParam(value = "modelo", required = false) String modelo,
            @RequestParam(value = "cor", required = false) String cor,
            @RequestParam(value = "placa", required = false) String placa,
            UriComponentsBuilder uriBuilder) {

        Client client = new Client(name, cpf, email, bairro, numero, rua);

        if (modelo != null && cor != null && placa != null) {

            Car car = new Car(modelo, cor, placa);
            client.getCars().add(car);
            car.setClient(client);
            //this.carRepository.saveAll(client.getCars());
        }
        client = this.clientRepository.save(client);


        URI path = uriBuilder.path("v1/client")
                .buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(path).body(new ClientPresenter(client));

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientPresenter> listClients(ClientPresenter clientPresenter) {

        List<Client> client = this.clientRepository.findAll();

        return ClientPresenter.listFromClients(client);
    }
}
