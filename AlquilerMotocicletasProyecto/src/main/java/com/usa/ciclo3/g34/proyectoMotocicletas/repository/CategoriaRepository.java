/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.repository;

import com.usa.ciclo3.g34.proyectoMotocicletas.repository.crud.CategoriaCrudRepository;
import com.usa.ciclo3.g34.proyectoMotocicletas.model.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jpine
 */
@Repository
public class CategoriaRepository {
    
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) categoriaCrudRepository.findAll();
    }
    
    public Optional<Categoria> getCategoria(int id){
        return categoriaCrudRepository.findById(id);
    }
    
    public Categoria save(Categoria category){
        return categoriaCrudRepository.save(category);
    }
    
    public void delete(Categoria category){
        categoriaCrudRepository.delete(category);
    }
}
