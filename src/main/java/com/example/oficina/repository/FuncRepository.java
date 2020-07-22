/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.repository;

import com.example.oficina.models.Client;
import com.example.oficina.models.Func;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Cast
 */
public interface FuncRepository extends CrudRepository<Func, Long>{
    
    @Override
    Func save(Func func);
    
    @Override
    List<Func> findAll();
    
    Func findAllById(Long id);
    
}
