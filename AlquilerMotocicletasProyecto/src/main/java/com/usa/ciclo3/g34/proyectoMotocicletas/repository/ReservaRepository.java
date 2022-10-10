/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.repository;

import com.usa.ciclo3.g34.proyectoMotocicletas.repository.crud.ReservaCrudRepository;
import com.usa.ciclo3.g34.proyectoMotocicletas.model.Reserva;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpine
 */
@Repository
public class ReservaRepository {
    
    @Autowired
    private ReservaCrudRepository reservaCrudRepository;
    
    public List<Reserva> getAll(){
        return (List<Reserva>) reservaCrudRepository.findAll();
    }
    
    public Optional<Reserva> getReserva(int id){
        return reservaCrudRepository.findById(id);
    }
    
    public Reserva save(Reserva reserva){
        return reservaCrudRepository.save(reserva);
    }
    
    public void delete(Reserva reserva){
        reservaCrudRepository.delete(reserva);
    }
}
