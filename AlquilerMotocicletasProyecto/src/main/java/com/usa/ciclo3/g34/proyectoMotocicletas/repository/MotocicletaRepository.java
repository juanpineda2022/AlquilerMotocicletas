/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.repository;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Motocicleta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpine
 */
@Repository
public class MotocicletaRepository {
    
    @Autowired
    private MotocicletaCrudRepository motocicletaCrudRepository;
    
    //GET
    public List<Motocicleta> getAll(){
        return (List<Motocicleta>) motocicletaCrudRepository.findAll();
    }
    
    //GETBYID
    public Optional<Motocicleta> getMotocicleta(int id){
        return motocicletaCrudRepository.findById(id);
    }
    
    //POST AND PUT
    public Motocicleta save(Motocicleta motorbike){
        return motocicletaCrudRepository.save(motorbike);
    }
    
    //DELETE
    public void delete(Motocicleta motorbike){
        motocicletaCrudRepository.delete(motorbike);
    }
}
