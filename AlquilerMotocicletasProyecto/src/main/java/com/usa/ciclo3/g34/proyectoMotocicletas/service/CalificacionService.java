/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.service;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Calificacion;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.CalificacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpine
 */
@Service
public class CalificacionService {
    
    @Autowired
    private CalificacionRepository calificacionRepository;
    
    //Lógica de negocio
    
    //GET
    public List<Calificacion> getAll(){
        return calificacionRepository.getAll();
    }
    
    public Optional<Calificacion> getCalificacion(int id){
        return calificacionRepository.getCalificacion(id);
    }
    
    //POST
    public Calificacion save(Calificacion calificacion){
        if(calificacion.getId()==null){
            return calificacionRepository.save(calificacion);
        }else{
            Optional<Calificacion> c = calificacionRepository.getCalificacion(calificacion.getId());
            if(c.isEmpty()){
                return calificacionRepository.save(calificacion);
            }else{
                return calificacion;
            }
        }
    }
    
    //PUT
    public Calificacion update(Calificacion calificacion){
        if(calificacion.getId()!=null){
            Optional<Calificacion> c = calificacionRepository.getCalificacion(calificacion.getId());
            if(!c.isEmpty()){
                if(calificacion.getCalificacion()!=null){
                    c.get().setCalificacion(calificacion.getCalificacion());
                }
                if(calificacion.getMessage()!=null){
                    c.get().setMessage(calificacion.getMessage());
                }
                calificacionRepository.save(c.get());
                return c.get();
            }else{
                return calificacion;
            }
        }else{
            return calificacion;
        }    
    }
    
    public boolean deleteCalificacion(int id){
        boolean flag=false;
        Optional<Calificacion> c= calificacionRepository.getCalificacion(id);
        if(c.isPresent()){
            calificacionRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
    
//    //DELETE
//    public boolean deleteCalificacion(int id){
//        Boolean cBoolean = getCalificacion(id).map(calificacion -> {
//            calificacionRepository.delete(calificacion);
//            return true;
//        }).orElse(false);
//        return cBoolean;
//    }
}
