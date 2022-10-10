/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.service;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Cliente;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpine
 */
@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    //Lógica de negocio
    
    //GET
    public List<Cliente> getAll(){
        return clienteRepository.getAll();
    }
    
    public Optional<Cliente> getCliente(int id){
        return clienteRepository.getCliente(id);
    }
    
    //POST
    public Cliente save(Cliente cliente){
        if(cliente.getIdClient()==null){
            return clienteRepository.save(cliente);
        }else{
            Optional<Cliente> c = clienteRepository.getCliente(cliente.getIdClient());
            if(c.isEmpty()){
                return clienteRepository.save(cliente);
            }else{
                return cliente;
            }
        }
    }
    
    //PUT
    public Cliente update(Cliente cliente){
        if(cliente.getIdClient()!=null){
            Optional<Cliente> c = clienteRepository.getCliente(cliente.getIdClient());
            if(!c.isEmpty()){
                if(cliente.getName()!=null){
                    c.get().setName(cliente.getName());
                }
                if(cliente.getEmail()!=null){
                    c.get().setEmail(cliente.getEmail());
                }
                if(cliente.getPassword()!=null){
                    c.get().setPassword(cliente.getPassword());
                }
                if(cliente.getAge()!=null){
                    c.get().setAge(cliente.getAge());
                }
                clienteRepository.save(c.get());
                return c.get();
            }else{
                return cliente;
            }
        }else{
            return cliente;
        }    
    }
    
    public boolean deleteCliente(int id){
        boolean flag=false;
        Optional<Cliente> c= clienteRepository.getCliente(id);
        if(c.isPresent()){
            clienteRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
    
//    //DELETE
//    public boolean deleteCliente(int id){
//        Boolean cBoolean = getCliente(id).map(cliente -> {
//            clienteRepository.delete(cliente);
//            return true;
//        }).orElse(false);
//        return cBoolean;
//    }
}
