/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.repository;

import com.usa.ciclo3.g34.proyectoMotocicletas.repository.crud.ClienteCrudRepository;
import com.usa.ciclo3.g34.proyectoMotocicletas.model.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpine
 */
@Repository
public class ClienteRepository {
    
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    
    public List<Cliente> getAll(){
        return (List<Cliente>) clienteCrudRepository.findAll();
    }
    
    public Optional<Cliente> getCliente(int id){
        return clienteCrudRepository.findById(id);
    }
    
    public Cliente save(Cliente cliente){
        return clienteCrudRepository.save(cliente);
    }
    
    public void delete(Cliente cliente){
        clienteCrudRepository.delete(cliente);
    }
    
}
