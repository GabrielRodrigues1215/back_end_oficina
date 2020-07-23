/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.controllers;

import com.example.oficina.models.Func;
import com.example.oficina.models.Orcamento;
import com.example.oficina.models.Piece;
import com.example.oficina.presenter.FuncPresenter;
import com.example.oficina.presenter.PiecePresenter;
import com.example.oficina.repository.FuncRepository;
import com.example.oficina.repository.PieceRepository;
import java.net.URI;
import java.util.Date;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Cast
 */
@RestController
@RequestMapping("v1/piece")
public class PieceController {

    @Autowired
    public PieceRepository pieceRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PiecePresenter> createFunc(
            @PathParam(value = "name") String name,
            @PathParam(value = "descricao") String descricao,
            @PathParam(value = "preco") Double preco,
            @PathParam(value = "qtdPiece") Long qtdPiece,
            UriComponentsBuilder uriBuilder) {
        
        Piece piece = new Piece(name, descricao, preco, qtdPiece );

        piece = this.pieceRepository.save(piece);

        URI path = uriBuilder.path("v1/piece")
                .buildAndExpand(piece.getId()).toUri();

        return ResponseEntity.created(path).body(new PiecePresenter(piece));

    }

}
