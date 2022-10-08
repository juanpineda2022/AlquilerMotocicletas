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
    public Categoria save(Categoria categoria){
        if(categoria.getId()==null){
            return categoriaRepository.save(categoria);
        }else{
            Optional<Categoria> m = categoriaRepository.getCategoria(categoria.getId());
            if(m.isEmpty()){
                return categoriaRepository.save(categoria);
            }else{
                return categoria;
            }
        }
    }
    
    //PUT
    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria> c = categoriaRepository.getCategoria(categoria.getId());
            if(!c.isEmpty()){
                if(categoria.getName()!=null){
                    c.get().setName(categoria.getName());
                }
                if(categoria.getDescripction()!=null){
                    c.get().setDescripction(categoria.getDescripction());
                }
                categoriaRepository.save(c.get());
                return c.get();
            }else{
                return categoria;
            }
        }else{
            return categoria;
        }    
    }
    
    //DELETE
    public boolean deleteCategoria(int id){
        Boolean cBoolean = getCategoria(id).map(categoria -> {
            categoriaRepository.delete(categoria);
            return true;
        }).orElse(false);
        return cBoolean;
    }
}
