/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.service;

import com.usa.ciclo3.g34.proyectoMotocicletas.model.Admin;
import com.usa.ciclo3.g34.proyectoMotocicletas.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpine
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    //Lógica de negocio
    
    //GET
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    //POST
    public Admin save(Admin admin){
        if(admin.getId()==null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> a = adminRepository.getAdmin(admin.getId());
            if(a.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }
    }
    
    //PUT
    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin> a = adminRepository.getAdmin(admin.getId());
            if(!a.isEmpty()){
                if(admin.getName()!=null){
                    a.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    a.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    a.get().setPassword(admin.getPassword());
                }
                adminRepository.save(a.get());
                return a.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }    
    }
    
    //DELETE
    public boolean deleteAdmin(int id){
        Boolean cBoolean = getAdmin(id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return cBoolean;
    }
}
