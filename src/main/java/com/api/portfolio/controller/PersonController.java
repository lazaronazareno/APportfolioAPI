/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.controller;

import com.api.portfolio.model.Person;
import com.api.portfolio.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/person")
public class PersonController {
    
    @Autowired IPersonService interPerson;
    
    @GetMapping()
    public ResponseEntity<Person> getPerson() {
        Person pers = interPerson.getPerson();
        return ResponseEntity.status(HttpStatus.OK).body(pers);
    }
    
    @PostMapping()
    public ResponseEntity<Person> savePerson (@RequestBody Person pers){
        Person firstPerson = interPerson.getPerson();
        
        if(firstPerson == null) {
            interPerson.savePerson(pers);
        } else {
            interPerson.deletePerson(firstPerson.getId());
            interPerson.savePerson(pers);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(pers);
    }
    
    @PutMapping()
    public ResponseEntity<Person> editPerson(@RequestBody Person pers){
        Person person = interPerson.getPerson();
        
        person.setName(pers.getName() == null ? person.getName() : pers.getName());
        person.setLastName(pers.getLastName() == null ? person.getLastName() : pers.getLastName());
        person.setBirth(pers.getBirth() == null ? person.getBirth() : pers.getBirth());
        person.setNationality(pers.getNationality() == null ? person.getNationality() : pers.getNationality());
        person.setTel(pers.getTel() == null ? person.getTel() : pers.getTel());
        person.setAddress(pers.getAddress() == null ? person.getAddress() : pers.getAddress());
        person.setMail(pers.getMail() == null ? person.getMail() : pers.getMail());
        person.setAbout_me(pers.getAbout_me() == null ? person.getAbout_me() : pers.getAbout_me());
        person.setOcupation(pers.getOcupation() == null ? person.getOcupation() : pers.getOcupation());
        person.setPhoto_url(pers.getPhoto_url() == null ? person.getPhoto_url() : pers.getPhoto_url());
        person.setBackground_url(pers.getBackground_url() == null ? person.getBackground_url() : pers.getBackground_url());
        person.setRepo_url(pers.getRepo_url() == null ? person.getRepo_url() : pers.getRepo_url());
        person.setLinkedin_url(pers.getLinkedin_url() == null ? person.getLinkedin_url() : pers.getLinkedin_url());
        
        interPerson.savePerson(person);
        
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }
}
