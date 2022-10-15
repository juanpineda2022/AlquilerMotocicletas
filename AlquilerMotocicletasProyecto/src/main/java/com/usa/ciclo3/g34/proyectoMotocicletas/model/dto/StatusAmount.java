/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.model.dto;

/**
 *
 * @author jpine
 */
public class StatusAmount {
    private int completed;
    private int cancelled;

    public StatusAmount() {
    }

    public StatusAmount(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public String toString() {
        return "StatusAmount{" + "completed=" + completed + ", cancelled=" + cancelled + '}';
    }
    
    
}