/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class Reservacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime startDate;
    private LocalDateTime sevolutionDate;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "motocicleta")
    @JsonIgnoreProperties("reservations")
    private Motocicleta motorbike;
    
    @ManyToOne
    @JoinColumn(name = "cliente")
    @JsonIgnoreProperties("reservations")
    private Cliente client;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private List<Calificacion> score;

    public Reservacion() {
    }

    public Reservacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getSevolutionDate() {
        return sevolutionDate;
    }

    public void setSevolutionDate(LocalDateTime sevolutionDate) {
        this.sevolutionDate = sevolutionDate;
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
        return "Reservacion{" + "id=" + id + ", startDate=" + startDate + ", sevolutionDate=" + sevolutionDate + ", status=" + status + ", motorbike=" + motorbike + ", client=" + client + ", score=" + score + '}';
    }
    
    
    
}
