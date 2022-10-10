/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.controller;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Motocicleta;
import com.usa.ciclo3.g34.proyectoMotocicletas.service.MotocicletaService;
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
@RequestMapping("/api/Motorbike")
public class MotocicletaController {
    
    @Autowired
    private MotocicletaService motocicletaService;
    //GET
    @GetMapping("/all")
    public List<Motocicleta> getMotocicletas(){
        return motocicletaService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Motocicleta> getMotocicleta(@PathVariable("id") int motocicletaId){
        return motocicletaService.getMotocicleta(motocicletaId);
    }
    
    //POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void motocicletaSave(@RequestBody Motocicleta motocicleta){
        motocicletaService.save(motocicleta);
    }
    
    //PUT
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void motocicletaUpdate(@RequestBody Motocicleta motocicleta){
        motocicletaService.update(motocicleta);
    }
    
    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return motocicletaService.deleteMotocicleta(id);
    }
    
//    //POST
//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Motocicleta save(@RequestBody Motocicleta motocicleta){
//        return motocicletaService.save(motocicleta);
//    }
//    
//    //PUT
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Motocicleta update(@RequestBody Motocicleta motocicleta){
//        return motocicletaService.update(motocicleta);
//    }
    
}
