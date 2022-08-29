/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.config.ResourceNotFoundException;
import com.api.portfolio.model.Person;
import com.api.portfolio.model.Person_User;
import com.api.portfolio.repository.Person_UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lazar
 */
@Service
public class Person_UserService implements IPerson_UserService {
    
    @Autowired Person_UserRepository userRepo;

    @Override
    public List<Person_User> getUsers() {
        List<Person_User> listUsers = userRepo.findAll();
        return listUsers;
    }

    @Override
    public void saveUser(Person_User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(int id) {
        Person_User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with ID : " + id + " not found"));
        
        userRepo.deleteById(user.getId());
    }

    @Override
    public Person_User findUser(int id) {
        Person_User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with ID : " + id + " not found"));
        return user;
    }
    
}
