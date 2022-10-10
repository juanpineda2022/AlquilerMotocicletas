/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.repository;

import com.usa.ciclo3.g34.proyectoMotocicletas.repository.crud.CalificacionCrudRepository;
import com.usa.ciclo3.g34.proyectoMotocicletas.model.Calificacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpine
 */
@Repository
public class CalificacionRepository {
    
    @Autowired
    private CalificacionCrudRepository calificacionCrudRepository;
    
    public List<Calificacion> getAll(){
        return (List<Calificacion>) calificacionCrudRepository.findAll();
    }
    
    public Optional<Calificacion> getCalificacion(int id){
        return calificacionCrudRepository.findById(id);
    }
    
    public Calificacion save(Calificacion calificacion){
        return calificacionCrudRepository.save(calificacion);
    }
    
    public void delete(Calificacion calificacion){
        calificacionCrudRepository.delete(calificacion);
    }
    
}
