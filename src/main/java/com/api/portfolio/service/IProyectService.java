/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.model.Proyect;
import java.util.List;

/**
 *
 * @author lazar
 */
public interface IProyectService {
    
    public List<Proyect> getProyects();
    
    public void SaveProyect(Proyect work);
    
    public void deleteProyect(int id);
    
    public Proyect findProyect(int id);
}
