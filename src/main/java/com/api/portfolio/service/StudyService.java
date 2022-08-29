/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.config.ResourceNotFoundException;
import com.api.portfolio.model.Study;
import com.api.portfolio.repository.StudyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lazar
 */
@Service
public class StudyService implements IStudyService {
    
    @Autowired StudyRepository studyRepo;

    @Override
    public List<Study> getStudies() {
        List<Study> studies = studyRepo.findAll();
        return studies;
    }

    @Override
    public void saveStudy(Study study) {
        studyRepo.save(study);
    }

    @Override
    public void deleteStudy(int id) {
        Study study = studyRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Study with ID : " + id + " not found"));
        studyRepo.deleteById(study.getId());
    }

    @Override
    public Study findStudy(int id) {
        Study study = studyRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Study with ID : " + id + " not found"));
        return study;
    }
    
}
