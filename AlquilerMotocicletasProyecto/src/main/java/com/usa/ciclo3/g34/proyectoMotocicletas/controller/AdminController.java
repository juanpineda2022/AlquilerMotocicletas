/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.controller;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Admin;
import com.usa.ciclo3.g34.proyectoMotocicletas.service.AdminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpine
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Admin")
public class AdminController {
    
    @Autowired
    private AdminService adminService;
    //GET
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> getAdmins(){
        return adminService.getAll();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Admin> getAdmin(@PathVariable("id") int adminId){
        return adminService.getAdmin(adminId);
    }
    
    //POST
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void adminSave(@RequestBody Admin admin){
        adminService.save(admin);
    }
    
    //PUT
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void adminUpdate(@RequestBody Admin admin){
        adminService.update(admin);
    }
    
    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        adminService.deleteAdmin(id);
    }
    
//    //POST
//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.OK)
//    public Admin save(@RequestBody Admin admin){
//        return adminService.save(admin);
//    }
//    
//    //PUT
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Admin update(@RequestBody Admin admin){
//        return adminService.update(admin);
//    }
    
}
