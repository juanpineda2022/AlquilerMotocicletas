/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
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
@Table(name = "mensaje")
public class Mensaje implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    @Column(length = 250)
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "motocicletaId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Motocicleta motorbike;
    
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Cliente client;

    public Mensaje() {
    }

    public Mensaje(Integer id) {
        this.idMessage = id;
    }

    public Mensaje(Integer id, String messageText, Motocicleta motorbike, Cliente client) {
        this.idMessage = id;
        this.messageText = messageText;
        this.motorbike = motorbike;
        this.client = client;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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

    @Override
    public String toString() {
        return "Mensaje{" + "id=" + idMessage + ", messageText=" + messageText + ", motorbike=" + motorbike + ", client=" + client + '}';
    }
    
    
}
