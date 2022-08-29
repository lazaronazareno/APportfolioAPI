/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.controller;

import com.api.portfolio.model.Person;
import com.api.portfolio.model.Stack;
import com.api.portfolio.service.IPersonService;
import com.api.portfolio.service.IStackService;
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
@RequestMapping("/stack")
public class StackController {
    
    @Autowired IStackService interStack;
    @Autowired IPersonService interPerson;
    
    @GetMapping ()
    public ResponseEntity<List<Stack>> getStacks(){
        List<Stack> stack = interStack.getStack();
        
        return new ResponseEntity<>(stack, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Stack> getStackById(@PathVariable int id){
        Stack stack = interStack.findStack(id);
        
        return new ResponseEntity<>(stack, HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<String> saveStack(@RequestBody Stack stack){
        Person person = interPerson.getPerson();
        
        stack.setPerson(person);
        interStack.saveStack(stack);
        
        return new ResponseEntity<>("Stack Successfully created", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Stack> editStack(@PathVariable int id, @RequestBody Stack stack){
        Stack sta = interStack.findStack(id);
        
        sta.setName(stack.getName() == null ? sta.getName() : stack.getName());
        sta.setDescription(stack.getDescription() == null ? sta.getDescription() : stack.getDescription());
        sta.setPhoto_url(stack.getPhoto_url() == null ? sta.getPhoto_url() : stack.getPhoto_url());
        sta.setPerson(stack.getPerson() == null ? sta.getPerson() : stack.getPerson());
        
        interStack.saveStack(sta);
        
        return new ResponseEntity<>(sta, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStack(@PathVariable int id){
        interStack.deleteStack(id);
        
        return new ResponseEntity<>("stack Successfully deleted", HttpStatus.OK);
    }
    
}
