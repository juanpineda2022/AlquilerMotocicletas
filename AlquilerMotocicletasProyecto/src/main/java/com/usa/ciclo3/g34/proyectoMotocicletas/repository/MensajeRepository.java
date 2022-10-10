/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.repository;

import com.usa.ciclo3.g34.proyectoMotocicletas.repository.crud.MensajeCrudRepository;
import com.usa.ciclo3.g34.proyectoMotocicletas.model.Mensaje;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpine
 */
@Repository
public class MensajeRepository {
    
    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;
    
    public List<Mensaje> getAll(){
        return (List<Mensaje>) mensajeCrudRepository.findAll();
    }
    
    public Optional<Mensaje> getMensaje(int id){
        return mensajeCrudRepository.findById(id);
    }
    
    public Mensaje save(Mensaje mensaje){
        return mensajeCrudRepository.save(mensaje);
    }
    
    public void delete(Mensaje mensaje){
        mensajeCrudRepository.delete(mensaje);
    }
}
