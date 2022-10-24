/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.controller;

import com.api.portfolio.model.Person;
import com.api.portfolio.model.Proyect;
import com.api.portfolio.service.IPersonService;
import com.api.portfolio.service.IProyectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lazar
 */
@RestController
@CrossOrigin(origins ="https://argprograma-front.web.app")
@RequestMapping("/proyect")
public class ProyectController {
    
    @Autowired IProyectService interProyect;
    @Autowired IPersonService interPerson;

    
    @GetMapping ()
    public ResponseEntity<List<Proyect>> getProyects(){
        List<Proyect> proy = interProyect.getProyects();
        
        return ResponseEntity.status(HttpStatus.OK).body(proy);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Proyect> getProyectById(@PathVariable int id){
        Proyect proy = interProyect.findProyect(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(proy);
    }
    
    @PostMapping()
    public ResponseEntity<Proyect> saveProyect(@RequestBody Proyect proyect){
        Person person = interPerson.getPerson();

        proyect.setPerson(person);
        interProyect.SaveProyect(proyect);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(proyect);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Proyect> editproyect(@PathVariable int id, @RequestBody Proyect proyect){
        Proyect proy = interProyect.findProyect(id);
        
        proy.setName(proyect.getName() == null ? proy.getName() : proyect.getName());
        proy.setYear_made(proyect.getYear_made() == 0 ? proy.getYear_made() : proyect.getYear_made());
        proy.setDescription(proyect.getDescription() == null ? proy.getDescription() : proyect.getDescription());
        proy.setStack(proyect.getStack() == null ? proy.getStack() : proyect.getStack());
        proy.setPhoto_url(proyect.getPhoto_url() == null ? proy.getPhoto_url() : proyect.getPhoto_url());
        proy.setRepo_url(proyect.getRepo_url() == null ? proy.getRepo_url() : proyect.getRepo_url());
        proy.setDeploy_url(proyect.getDeploy_url() == null ? proy.getDeploy_url() : proyect.getDeploy_url());
        proy.setPerson(proyect.getPerson() == null ? proy.getPerson() : proyect.getPerson());

        interProyect.SaveProyect(proy);
        
        return ResponseEntity.status(HttpStatus.OK).body(proy);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteproyect(@PathVariable int id){
        interProyect.deleteProyect(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(String.format("proyect %d successfully deleted", id));
    }
    
}
