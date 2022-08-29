/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.config.ResourceNotFoundException;
import com.api.portfolio.model.Experience;
import com.api.portfolio.repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lazar
 */
@Service
public class ExperienceService implements IExperienceService {
    
    @Autowired ExperienceRepository expRepo;

    @Override
    public List<Experience> getExperiences() {
        List<Experience> listExp = expRepo.findAll();
        return listExp;
    }

    @Override
    public void SaveExp(Experience exp) {
        expRepo.save(exp);
    }

    @Override
    public void deletePerson(int id) {
         Experience exp = expRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Experience with ID : " + id + " not found"));
        expRepo.deleteById(exp.getId());
    }

    @Override
    public Experience findExp(int id) {
        Experience exp = expRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Experience with ID : " + id + " not found"));
        return exp;
    }
    
}
