/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.controller;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Cliente;
import com.usa.ciclo3.g34.proyectoMotocicletas.service.ClienteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpine
 */
@RestController
@RequestMapping("/api/Client")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    //GET
    @GetMapping("/all")
    public List<Cliente> getClientes(){
        return clienteService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") int clienteId){
        return clienteService.getCliente(clienteId);
    }
    
    //POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void clienteSave(@RequestBody Cliente cliente){
        clienteService.save(cliente);
    }
    
    //PUT
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void clienteUpdate(@RequestBody Cliente cliente){
        clienteService.update(cliente);
    }
    
    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return clienteService.deleteCliente(id);
    }
    
//    //POST
//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Cliente save(@RequestBody Cliente cliente){
//        return clienteService.save(cliente);
//    }
//    
//    //PUT
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Cliente update(@RequestBody Cliente cliente){
//        return clienteService.update(cliente);
//    }
}
