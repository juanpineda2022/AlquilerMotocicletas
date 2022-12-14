/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.controller;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Calificacion;
import com.usa.ciclo3.g34.proyectoMotocicletas.service.CalificacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpine
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Score")
public class CalificacionController {
    
    @Autowired
    private CalificacionService calificacionService;
    //GET
    @GetMapping("/all")
//    @ResponseStatus(HttpStatus.OK)
    public List<Calificacion> getCalificaciones(){
        return calificacionService.getAll();
    }
    
    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public Optional<Calificacion> getCalificacion(@PathVariable("id") int calificacionId){
        return calificacionService.getCalificacion(calificacionId);
    }
    
    //POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void calificacionSave(@RequestBody Calificacion calificacion){
        calificacionService.save(calificacion);
    }
    
    //PUT
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void calificacionUpdate(@RequestBody Calificacion calificacion){
        calificacionService.update(calificacion);
    }
    
    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        calificacionService.deleteCalificacion(id);
    }
    
//        //POST
//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.OK)
//    public Calificacion save(@RequestBody Calificacion calificacion){
//        return calificacionService.save(calificacion);
//    }
//    
//    //PUT
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Calificacion update(@RequestBody Calificacion calificacion){
//        return calificacionService.update(calificacion);
//    }
}
