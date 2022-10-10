/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.service;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Reserva;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.ReservaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpine
 */
@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;
    
    //Lógica de negocio
    
    //GET
    public List<Reserva> getAll(){
        return reservaRepository.getAll();
    }
    
    public Optional<Reserva> getReserva(int id){
        return reservaRepository.getReserva(id);
    }
    
    //POST
    public Reserva save(Reserva reserva){
        if(reserva.getIdReservation()==null){
            return reservaRepository.save(reserva);
        }else{
            Optional<Reserva> r = reservaRepository.getReserva(reserva.getIdReservation());
            if(r.isEmpty()){
                return reservaRepository.save(reserva);
            }else{
                return reserva;
            }
        }
    }
    
    //PUT
    public Reserva update(Reserva reserva){
        if(reserva.getIdReservation()!=null){
            Optional<Reserva> r = reservaRepository.getReserva(reserva.getIdReservation());
            if(!r.isEmpty()){
                if(reserva.getStartDate()!=null){
                    r.get().setStartDate(reserva.getStartDate());
                }
                if(reserva.getDevolutionDate()!=null){
                    r.get().setDevolutionDate(reserva.getDevolutionDate());
                }
                if(reserva.getStatus()!=null){
                    r.get().setStatus(reserva.getStatus());
                }
                reservaRepository.save(r.get());
                return r.get();
            }else{
                return reserva;
            }
        }else{
            return reserva;
        }    
    }
    
    //DELETE
    public boolean deleteReserva(int id){
        Boolean rBoolean = getReserva(id).map(reserva -> {
            reservaRepository.delete(reserva);
            return true;
        }).orElse(false);
        return rBoolean;
    }
}
