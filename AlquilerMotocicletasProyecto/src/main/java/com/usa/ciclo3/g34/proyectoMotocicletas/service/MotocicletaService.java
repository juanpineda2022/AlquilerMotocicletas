/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.service;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Motocicleta;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.MotocicletaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpine
 */
@Service
public class MotocicletaService {
    
    @Autowired
    private MotocicletaRepository motocicletaRepository;
    
    //Lógica de negocio
    
    //GET
    public List<Motocicleta> getAll(){
        return motocicletaRepository.getAll();
    }
    
    public Optional<Motocicleta> getMotocicleta(int id){
        return motocicletaRepository.getMotocicleta(id);
    }
    
    //POST
    public Motocicleta save(Motocicleta motorbike){
        if(motorbike.getId()==null){
            return motocicletaRepository.save(motorbike);
        }else{
            Optional<Motocicleta> m = motocicletaRepository.getMotocicleta(motorbike.getId());
            if(m.isEmpty()){
                return motocicletaRepository.save(motorbike);
            }else{
                return motorbike;
            }
        }
    }
    
    //PUT
    public Motocicleta update(Motocicleta motorbike){
        if(motorbike.getId()!=null){
            Optional<Motocicleta> m = motocicletaRepository.getMotocicleta(motorbike.getId());
            if(!m.isEmpty()){
                if(motorbike.getName()!=null){
                    m.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    m.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getYear()!=null){
                    m.get().setYear(motorbike.getYear());
                }
                if(motorbike.getDescription()!=null){
                    m.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    m.get().setCategory(motorbike.getCategory());
                }
                motocicletaRepository.save(m.get());
                return m.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;
        }    
    }
    
    public boolean deleteMotocicleta(int id){
        boolean flag=false;
        Optional<Motocicleta> m= motocicletaRepository.getMotocicleta(id);
        if(m.isPresent()){
            motocicletaRepository.delete(m.get());
            flag=true;
        }
        return flag;
    }
    
//    //DELETE
//    public boolean deleteMotocicleta(int id){
//        Boolean mBoolean = getMotocicleta(id).map(motorbike -> {
//            motocicletaRepository.delete(motorbike);
//            return true;
//        }).orElse(false);
//        return mBoolean;
//    }
    
}