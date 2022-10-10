/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jpine
 */
@Entity
@Table(name="reservas")
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    //Modificar después
    private String status = "created";
    
    @ManyToOne
    @JoinColumn(name = "motocicleta")
    @JsonIgnoreProperties("reservations")
    private Motocicleta motorbike;
    
    @ManyToOne
    @JoinColumn(name = "cliente")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Cliente client;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private List<Calificacion> score;

    public Reserva() {
    }

    public Reserva(Integer id) {
        this.idReservation = id;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Motocicleta getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motocicleta motorbike) {
        this.motorbike = motorbike;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<Calificacion> getScore() {
        return score;
    }

    public void setScore(List<Calificacion> score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + idReservation + ", startDate=" + startDate + ", devolutionDate=" + devolutionDate + ", status=" + status + ", motorbike=" + motorbike + ", client=" + client + ", score=" + score + '}';
    }
    
    
}
