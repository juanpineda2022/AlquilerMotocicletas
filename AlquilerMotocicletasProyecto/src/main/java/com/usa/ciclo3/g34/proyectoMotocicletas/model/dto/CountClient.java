/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.model.dto;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Cliente;

/**
 *
 * @author jpine
 */
public class CountClient {
    private Long total;
    private Cliente client;

    public CountClient() {
    }

    public CountClient(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "CountClient{" + "total=" + total + ", client=" + client + '}';
    }
    
    
}
