/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.controller;

import com.api.portfolio.model.Person_User;
import com.api.portfolio.service.IPerson_UserService;
import com.api.portfolio.service.JwtUserDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lazar
 */
@RestController
@RequestMapping("/user")
public class Person_userController {
    
    @Autowired IPerson_UserService interUser;
    
    @Autowired private JwtUserDetailsService userDetailsService;
        
    @GetMapping ()
    public ResponseEntity<List<Person_User>> getUsers(){
        List<Person_User> user = interUser.getUsers();
        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Person_User> getUserById(@PathVariable int id){
        Person_User user = interUser.findUser(id);
        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> editUser(@PathVariable int id, @RequestBody Person_User user){
        Person_User usr = interUser.findUser(id);
        
        usr.setEmail(user.getEmail());
        usr.setPassword(user.getPassword());
        
        userDetailsService.save(usr);
        
        return new ResponseEntity<>("User Successfully updated", HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        interUser.deleteUser(id);
        
        return new ResponseEntity<>("User Successfully deleted", HttpStatus.OK);
    }
}
