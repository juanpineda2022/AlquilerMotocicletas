/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.controller;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Mensaje;
import com.usa.ciclo3.g34.proyectoMotocicletas.service.MensajeService;
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
@RequestMapping("/api/Message")
public class MensajeController {
    
    @Autowired
    private MensajeService mensajeService;
    //GET
    @GetMapping("/all")
    public List<Mensaje> getMensajes(){
        return mensajeService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Mensaje> getMensaje(@PathVariable("id") int mensajeId){
        return mensajeService.getMensaje(mensajeId);
    }
    
    //POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void mensajeSave(@RequestBody Mensaje mensaje){
        mensajeService.save(mensaje);
    }
    
    //PUT
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void mensajeUpdate(@RequestBody Mensaje mensaje){
        mensajeService.update(mensaje);
    }
    
    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return mensajeService.deleteMensaje(id);
    }
    
//    //POST
//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mensaje save(@RequestBody Mensaje mensaje){
//        return mensajeService.save(mensaje);
//    }
//    
//    //PUT
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mensaje update(@RequestBody Mensaje mensaje){
//        return mensajeService.update(mensaje);
//    }
}
