/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.controllers;

import com.example.oficina.models.Car;
import com.example.oficina.models.Client;
import com.example.oficina.presenter.CarPresenter;
import com.example.oficina.presenter.ClientPresenter;
import com.example.oficina.repository.ClientRepository;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientPresenter> findByIdClient(ClientPresenter clientPresenter,
            @PathVariable Long id,
            UriComponentsBuilder uriBuilder) {

        Client client = this.clientRepository.findAllById(id);

        URI path = uriBuilder.path("v1/client/{id}")
                .buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(path).body(new ClientPresenter(client));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientPresenter> alterClient(ClientPresenter clientPresenter,
            @PathVariable Long id,
            @RequestHeader(value = "nome", required = false) String nome,
            @RequestHeader(value = "cpf", required = false) String cpf,
            @RequestHeader(value = "email", required = false) String email,
            @RequestHeader(value = "rua", required = false) String rua,
            @RequestHeader(value = "bairro", required = false) String bairro,
            @RequestHeader(value = "numero", required = false) Long numero,
            @RequestHeader(value = "modelo", required = false) String modelo,
            @RequestHeader(value = "cor", required = false) String cor,
            @RequestHeader(value = "placa", required = false) String placa,
            UriComponentsBuilder uriBuilder) {

        Client client = this.clientRepository.findAllById(id);

        if (nome != null) {
            client.setName(nome);
        }
        if(cpf != null){
            client.setCpf(cpf);
        }
        if(email != null){
            client.setEmail(email);
        }
        if(rua != null){
            client.setRua(rua);
        }
        if(bairro != null){
            client.setBairro(bairro);
        }
        if(numero != null){
            client.setNumero(numero);
        }

        if (client.getCars() != null) {
            List<Car> cars = client.getCars();

            for (Car i : cars) {
                if (cor != null) {
                    i.setCor(cor);
                }
                if (modelo != null) {
                    i.setModelo(modelo);

                }
                if (placa != null) {
                    i.setPlaca(placa);
                }

            }

        }

        client = this.clientRepository.save(client);

        URI path = uriBuilder.path("v1/client/{id}")
                .buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(path).body(new ClientPresenter(client));
    }
    

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity deleteClient(
//            @PathVariable(value = "id", required = true) Long id,
//            UriComponentsBuilder uriBuilder) {
//        
//        
//        Client result = this.clientRepository.delete(id);
//        
//        URI path = uriBuilder.path("v1/client/{id}")
//                .buildAndExpand(result.getId()).toUri();
//
//        return ResponseEntity.created(path).body(new ClientPresenter(result));
//    }

}
