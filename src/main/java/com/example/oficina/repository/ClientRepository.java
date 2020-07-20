/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.oficina.repository;

import com.example.oficina.models.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gabriel
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    
    @Override
    List<Client> findAll();

    @Override
    Client save(Client client);
}
