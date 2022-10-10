/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.controller;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Categoria;
import com.usa.ciclo3.g34.proyectoMotocicletas.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpine
 */
@RestController
@RequestMapping("/api/Category")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    //GET
    @GetMapping("/all")
    public List<Categoria> getCategorias(){
        return categoriaService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Categoria> getCategoria(@PathVariable("id") int categoriaId){
        return categoriaService.getCategoria(categoriaId);
    }
    
    //POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void categoriasave(@RequestBody Categoria categoria){
        categoriaService.save(categoria);
    }
    
    //PUT
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void categoriaupdate(@RequestBody Categoria categoria){
        categoriaService.update(categoria);
    }
    
    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        categoriaService.deleteCategoria(id);
    }
    
    
      //POST
//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Categoria save(@RequestBody Categoria categoria){
//        return categoriaService.save(categoria);
//    }
    
//    //PUT
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Categoria update(@RequestBody Categoria categoria){
//        return categoriaService.update(categoria);
//    }
//    
//    //DELETE
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public boolean delete(@PathVariable("id") int id){
//        return categoriaService.deleteCategoria(id);
//    }
    
}
