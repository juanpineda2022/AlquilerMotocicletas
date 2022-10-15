/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.repository.crud;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Reserva;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jpine
 */
public interface ReservaCrudRepository extends CrudRepository<Reserva, Integer>{
    
    @Query("SELECT c.client, COUNT(c.client) FROM Reserva AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservasByCliente();
    
    public List<Reserva> findAllByStatus(String status);
    
    public List<Reserva> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);
}
