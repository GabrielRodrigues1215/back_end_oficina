/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.repository;

import com.example.oficina.models.Piece;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cast
 */
public interface PieceRepository extends CrudRepository<Piece, Long> {

    @Override
    Piece save(Piece piece);

    @Override
    List<Piece> findAll();

    Piece findAllById(Long id);

}
