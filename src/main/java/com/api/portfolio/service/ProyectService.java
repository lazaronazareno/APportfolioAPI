/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.config.ResourceNotFoundException;
import com.api.portfolio.model.Proyect;
import com.api.portfolio.repository.ProyectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lazar
 */
@Service
public class ProyectService implements IProyectService {
    
    @Autowired ProyectRepository proyRepo;

    @Override
    public List<Proyect> getProyects() {
        List<Proyect> works = proyRepo.findAll();
        return works;
    }

    @Override
    public void SaveProyect(Proyect work) {
        proyRepo.save(work);
    }

    @Override
    public void deleteProyect(int id) {
        Proyect proyect = proyRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Proyect with ID : " + id + " not found"));
        proyRepo.deleteById(proyect.getId());
    }

    @Override
    public Proyect findProyect(int id) {
        Proyect proyect = proyRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Proyect with ID : " + id + " not found"));
        return proyect;
    }
    
}
