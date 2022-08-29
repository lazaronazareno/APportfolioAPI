/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.model.Study;
import java.util.List;

/**
 *
 * @author lazar
 */
public interface IStudyService {
    
    public List<Study> getStudies();
    
    public void saveStudy (Study study);
    
    public void deleteStudy(int id);
    
    public Study findStudy(int id);
    
}
