/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.config.ResourceNotFoundException;
import com.api.portfolio.model.Stack;
import com.api.portfolio.repository.StackRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lazar
 */
@Service
public class StackService implements IStackService {
    
    @Autowired StackRepository stackRepo;

    @Override
    public List<Stack> getStack() {
        List<Stack> stacks = stackRepo.findAll();
        return stacks;
    }

    @Override
    public void saveStack(Stack stack) {
        stackRepo.save(stack);
    }

    @Override
    public void deleteStack(int id) {
         Stack stack = stackRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Stack with ID : " + id + " not found"));
         stackRepo.deleteById(stack.getId());
    }

    @Override
    public Stack findStack(int id) {
        Stack stack = stackRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Stack with ID : " + id + " not found"));
        return stack;
    }
    
}
