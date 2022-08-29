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
@RequestMapping("/experience")
public class ExperienceController {
    
    @Autowired IExperienceService interExp;
    @Autowired IPersonService interPerson;
    
    @GetMapping()
    public ResponseEntity<List<Experience>> getExperiences(){
        List<Experience> exp = interExp.getExperiences();
        
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable int id){
        Experience exp = interExp.findExp(id);
        
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<String> saveExperience(@RequestBody Experience exp) {
        Person person = interPerson.getPerson();
        
        exp.setPerson(person);
        interExp.SaveExp(exp);
        
        return new ResponseEntity<>("Experience Successfully created", HttpStatus.OK);
    }
    
    @PutMapping ("/{id}")
    public ResponseEntity<Experience> editExperience(@PathVariable int id, @RequestBody Experience exp){
        Experience ex = interExp.findExp(id);
        
        ex.setName(exp.getName() == null ? ex.getName() : exp.getName());
        ex.setIsActual(exp.getIsActual() == null ? ex.getIsActual() : exp.getIsActual());
        ex.setYear_init(exp.getYear_init() == 0 ? ex.getYear_init() : exp.getYear_init());
        ex.setYear_end(exp.getYear_end() == 0 ? ex.getYear_end() : exp.getYear_end());
        ex.setDescription(exp.getDescription() == null ? ex.getDescription() : exp.getDescription());
        ex.setPhoto_url(exp.getPhoto_url() == null ? ex.getPhoto_url() : exp.getPhoto_url());
        ex.setPerson(exp.getPerson() == null ? ex.getPerson() : exp.getPerson());
        
        interExp.SaveExp(ex);
        
        return new ResponseEntity<>(ex, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExperience (@PathVariable int id){
        interExp.deletePerson(id);
        
        return new ResponseEntity<>("Experience successfully deleted", HttpStatus.OK);
    }
    
}
