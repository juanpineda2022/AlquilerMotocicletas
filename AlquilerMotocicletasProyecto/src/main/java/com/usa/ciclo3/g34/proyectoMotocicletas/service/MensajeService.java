/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.service;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Mensaje;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.MensajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpine
 */
@Service
public class MensajeService {
    
    @Autowired
    private MensajeRepository mensajeRepository;
    
    //Lógica de negocio
    
    //GET
    public List<Mensaje> getAll(){
        return mensajeRepository.getAll();
    }
    
    public Optional<Mensaje> getMensaje(int id){
        return mensajeRepository.getMensaje(id);
    }
    
    //POST
    public Mensaje save(Mensaje mensaje){
        if(mensaje.getIdMessage()==null){
            return mensajeRepository.save(mensaje);
        }else{
            Optional<Mensaje> m = mensajeRepository.getMensaje(mensaje.getIdMessage());
            if(m.isEmpty()){
                return mensajeRepository.save(mensaje);
            }else{
                return mensaje;
            }
        }
    }
    
    //PUT
    public Mensaje update(Mensaje mensaje){
        if(mensaje.getIdMessage()!=null){
            Optional<Mensaje> m = mensajeRepository.getMensaje(mensaje.getIdMessage());
            if(!m.isEmpty()){
                if(mensaje.getMessageText()!=null){
                    m.get().setMessageText(mensaje.getMessageText());
                }
                mensajeRepository.save(m.get());
                return m.get();
            }else{
                return mensaje;
            }
        }else{
            return mensaje;
        }    
    }
    
    public boolean deleteMensaje(int id){
        boolean flag=false;
        Optional<Mensaje> m= mensajeRepository.getMensaje(id);
        if(m.isPresent()){
            mensajeRepository.delete(m.get());
            flag=true;
        }
        return flag;
    }
    
//    //DELETE
//    public boolean deleteMensaje(int id){
//        Boolean mBoolean = getMensaje(id).map(mensaje -> {
//            mensajeRepository.delete(mensaje);
//            return true;
//        }).orElse(false);
//        return mBoolean;
//    }
}
