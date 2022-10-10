/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jpine
 */

@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 1)
    private Integer calificacion;
    //Ver como hacer el set mysql 
    @Column(length = 250)
    private String message;
    
    @ManyToOne
    @JoinColumn(name="reserva")
    @JsonIgnoreProperties("score")
    private Reserva reservation;

    public Calificacion() {
    }

    public Calificacion(Integer id) {
        this.id = id;
    }

    public Calificacion(Integer id, Integer calificacion, String message, Reserva reservation) {
        this.id = id;
        this.calificacion = calificacion;
        this.message = message;
        this.reservation = reservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reserva getReservation() {
        return reservation;
    }

    public void setReservation(Reserva reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "id=" + id + ", calificacion=" + calificacion + ", message=" + message + ", reservation=" + reservation + '}';
    }
    
}
