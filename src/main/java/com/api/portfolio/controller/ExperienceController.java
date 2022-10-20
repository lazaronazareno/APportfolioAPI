/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.controller;

import com.api.portfolio.model.Experience;
import com.api.portfolio.model.Person;
import com.api.portfolio.service.IExperienceService;
import com.api.portfolio.service.IPersonService;
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
@RequestMapping("/experience")
public class ExperienceController {
    
    @Autowired IExperienceService interExp;
    @Autowired IPersonService interPerson;
    
    @GetMapping()
    public ResponseEntity<List<Experience>> getExperiences(){
        List<Experience> exp = interExp.getExperiences();
        
        return ResponseEntity.status(HttpStatus.OK).body(exp);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable int id){
        Experience exp = interExp.findExp(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(exp);
    }
    
    @PostMapping()
    public ResponseEntity<Experience> saveExperience(@RequestBody Experience exp) {
        Person person = interPerson.getPerson();
        
        exp.setPerson(person);
        interExp.SaveExp(exp);
        
        return ResponseEntity.status(HttpStatus.OK).body(exp);
    }
    
    @PutMapping ("/{id}")
    public ResponseEntity<Experience> editExperience(@PathVariable int id, @RequestBody Experience exp){
        Experience ex = interExp.findExp(id);
        
        ex.setPosition(exp.getPosition() == null ? ex.getPosition() : exp.getPosition());
        ex.setCompany(exp.getCompany() == null ? ex.getCompany() : exp.getCompany());
        ex.setMode(exp.getMode() == null ? ex.getMode() : exp.getMode());
        ex.setIsActual(exp.getIsActual() == null ? ex.getIsActual() : exp.getIsActual());
        ex.setDate_init(exp.getDate_init() == null ? ex.getDate_init() : exp.getDate_init());
        ex.setDate_end(exp.getDate_end() == null ? ex.getDate_end() : exp.getDate_end());
        ex.setDescription(exp.getDescription() == null ? ex.getDescription() : exp.getDescription());
        ex.setPhoto_url(exp.getPhoto_url() == null ? ex.getPhoto_url() : exp.getPhoto_url());
        ex.setPerson(exp.getPerson() == null ? ex.getPerson() : exp.getPerson());
        
        interExp.SaveExp(ex);
        
        return ResponseEntity.status(HttpStatus.OK).body(exp);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExperience (@PathVariable int id){
        interExp.deletePerson(id);
        
        return ResponseEntity.status(HttpStatus.OK).body("experience {id} successfully deleted");
    }
    
}
