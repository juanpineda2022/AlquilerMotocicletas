/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.service;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Categoria;
import com.usa.ciclo3.g34.proyectoMotocicletas.model.Motocicleta;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.CategoriaRepository;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.MotocicletaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpine
 */
@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    //Lógica de negocio
    
    //GET
    public List<Categoria> getAll(){
        return categoriaRepository.getAll();
    }
    
    public Optional<Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }
    
    //POST
    public Categoria save(Categoria category){
        if(category.getId()==null){
            return categoriaRepository.save(category);
        }else{
            Optional<Categoria> c = categoriaRepository.getCategoria(category.getId());
            if(c.isEmpty()){
                return categoriaRepository.save(category);
            }else{
                return category;
            }
        }
    }
    
    //PUT
    public Categoria update(Categoria category){
        if(category.getId()!=null){
            Optional<Categoria> c = categoriaRepository.getCategoria(category.getId());
            if(!c.isEmpty()){
                if(category.getName()!=null){
                    c.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    c.get().setDescripction(category.getDescription());
                }
                categoriaRepository.save(c.get());
                return c.get();
            }else{
                return category;
            }
        }else{
            return category;
        }    
    }
    
    //DELETE
    public boolean deleteCategoria(int id){
        Boolean cBoolean = getCategoria(id).map(category -> {
            categoriaRepository.delete(category);
            return true;
        }).orElse(false);
        return cBoolean;
    }
}
