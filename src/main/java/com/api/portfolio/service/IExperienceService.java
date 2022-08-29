/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.model.Experience;
import java.util.List;

/**
 *
 * @author lazar
 */
public interface IExperienceService {
    
    public List<Experience> getExperiences();
    
    public void SaveExp(Experience exp);
    
    public void deletePerson(int id);
    
    public Experience findExp(int id);
}
