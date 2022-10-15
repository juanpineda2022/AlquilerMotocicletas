/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.service;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Reserva;
import com.usa.ciclo3.g34.proyectoMotocicletas.model.dto.CountClient;
import com.usa.ciclo3.g34.proyectoMotocicletas.model.dto.StatusAmount;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.ReservaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public boolean deleteReserva(int id){
        boolean flag=false;
        Optional<Reserva> r= reservaRepository.getReserva(id);
        if(r.isPresent()){
            reservaRepository.delete(r.get());
            flag=true;
        }
        return flag;
    }
    
    public List<CountClient> getToClientes(){
        return reservaRepository.getTopClients();
    }
    
    public StatusAmount getReservaStatusAmoung(){
        List <Reserva> completed = reservaRepository.getReservasByStatus("completed");
        List <Reserva> cancelled = reservaRepository.getReservasByStatus("cancelled");
        return new StatusAmount(completed.size(), cancelled.size());
    }
    
    public List<Reserva> getReservasByTiempo(String dateA, String dateB){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = formato.parse(dateA);
            b = formato.parse(dateB);
        }catch(ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservaRepository.getReservasTiempo(a, b);
        }else{
            return new ArrayList<>();
        }
    }
    
//    //DELETE
//    public boolean deleteReserva(int id){
//        Boolean rBoolean = getReserva(id).map(reserva -> {
//            reservaRepository.delete(reserva);
//            return true;
//        }).orElse(false);
//        return rBoolean;
//    }
}
