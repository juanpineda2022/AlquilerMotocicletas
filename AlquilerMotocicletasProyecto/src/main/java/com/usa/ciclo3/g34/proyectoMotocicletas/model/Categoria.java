  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jpine
 */
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45, nullable = false)
    private String name;
    @Column(length = 250, nullable = false)
    private String description;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="category")
    @JsonIgnoreProperties({"category", "messages", "reservations"})
    private List<Motocicleta> motorbikes;

    public Categoria() {
    }

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String name, String description, List<Motocicleta> motorbikes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.motorbikes = motorbikes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescripction(String description) {
        this.description = description;
    }

    public List<Motocicleta> getMotorbikes() {
        return motorbikes;
    }

    public void setMotorbikes(List<Motocicleta> motorbikes) {
        this.motorbikes = motorbikes;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", name=" + name + ", description=" + description + ", motorbikes=" + motorbikes + '}';
    }
    
    
}
