/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.repository;

import com.example.oficina.models.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Gabriel
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

    @Override
    List<Client> findAll();

    @Override
    Client save(Client client);
       
    Client findAllById(Long id);
    
    @Override
    void deleteById(Long id);
   
   
}
