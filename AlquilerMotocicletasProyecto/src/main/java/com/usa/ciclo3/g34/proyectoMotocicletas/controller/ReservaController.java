/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.controller;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Reserva;
import com.usa.ciclo3.g34.proyectoMotocicletas.service.ReservaService;
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
@RequestMapping("/api/Reservation")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;
    //GET
    @GetMapping("/all")
    public List<Reserva> getReservas(){
        return reservaService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reserva> getReserva(@PathVariable("id") int reservaId){
        return reservaService.getReserva(reservaId);
    }
    
    //POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void reservaSave(@RequestBody Reserva reserva){
        reservaService.save(reserva);
    }
    
    //PUT
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void reservaUpdate(@RequestBody Reserva reserva){
        reservaService.update(reserva);
    }
    
    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservaService.deleteReserva(id);
    }
    
        //POST
//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Reserva save(@RequestBody Reserva reserva){
//        return reservaService.save(reserva);
//    }
    
//    //PUT
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Reserva update(@RequestBody Reserva reserva){
//        return reservaService.update(reserva);
//    }
    
}
