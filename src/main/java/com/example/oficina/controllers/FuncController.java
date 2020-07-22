/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.controllers;

import com.example.oficina.models.Car;
import com.example.oficina.models.Client;
import com.example.oficina.models.Func;
import com.example.oficina.presenter.ClientPresenter;
import com.example.oficina.presenter.FuncPresenter;
import com.example.oficina.repository.ClientRepository;
import com.example.oficina.repository.FuncRepository;
import java.net.URI;
import java.util.Date;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Cast
 */
@RestController
@RequestMapping("v1/func")
public class FuncController {

    @Autowired
    public FuncRepository funcRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuncPresenter> createFunc(
            @PathParam(value = "name") String name,
            @PathParam(value = "cpf") String cpf,
            @PathParam(value = "dtNascimento") Date dtNascimento,
            @PathParam(value = "email") String email,
            @PathParam(value = "telFix") String telFix,
            @PathParam(value = "telCel") String telCel,
            UriComponentsBuilder uriBuilder) {

        Func func = new Func(name, cpf, dtNascimento, email, telFix, telCel);

        func = this.funcRepository.save(func);

        URI path = uriBuilder.path("v1/func")
                .buildAndExpand(func.getId()).toUri();

        return ResponseEntity.created(path).body(new FuncPresenter(func));

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FuncPresenter> listFuncs(ClientPresenter clientPresenter) {

        List<Func> func = this.funcRepository.findAll();

        return FuncPresenter.listFromClients(func);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteClient(
            @PathVariable(value = "id", required = true) Long id,
            UriComponentsBuilder uriBuilder) {

        Func func = this.funcRepository.findAllById(id);

        if (func != null) {
            this.funcRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);

        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FuncPresenter> findByIdClient(FuncPresenter funcPresenter,
            @PathVariable Long id,
            UriComponentsBuilder uriBuilder) {

        Func func = this.funcRepository.findAllById(id);

        if (func == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        URI path = uriBuilder.path("v1/func/{id}")
                .buildAndExpand(func.getId()).toUri();

        return ResponseEntity.created(path).body(new FuncPresenter(func));
    }

}
