/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.config.ResourceNotFoundException;
import com.api.portfolio.model.Person;
import com.api.portfolio.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lazar
 */
@Service
public class PersonService implements IPersonService {
    
    @Autowired PersonRepository persRepo;
    
    @Override
    public Person getPerson() {
        List<Person> listPerson = persRepo.findAll();
        
        if(listPerson.isEmpty()){
            return null;
        } else {
            Person person = listPerson.get(0);
            return person;
        }
    }

    @Override
    public void savePerson(Person person) {
        persRepo.save(person);
    }

    @Override
    public void deletePerson(int id) {
        Person pers = persRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person with ID : " + id + " not found"));

        persRepo.deleteById(pers.getId());
    }
    
    @Override
    public Person findPerson(int id) {
        Person pers = persRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Person with ID : " + id + " not found"));
        return pers;
    }
}
