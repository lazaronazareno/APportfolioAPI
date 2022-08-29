/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.controller;

import com.api.portfolio.model.Person;
import com.api.portfolio.model.Study;
import com.api.portfolio.service.IPersonService;
import com.api.portfolio.service.IStudyService;
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
@RequestMapping("/study")
public class StudyController {
    
    @Autowired IStudyService interStudy;
    @Autowired IPersonService interPerson;
    
    @GetMapping ()
    public ResponseEntity<List<Study>> getStudies(){
        List<Study> study = interStudy.getStudies();
        
        return new ResponseEntity<>(study, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Study> getStudyById(@PathVariable int id){
        Study study = interStudy.findStudy(id);
        
        return new ResponseEntity<>(study, HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<String> saveStudy(@RequestBody Study study){
        Person person = interPerson.getPerson();
        
        study.setPerson(person);
        interStudy.saveStudy(study);
        
        return new ResponseEntity<>("Study Successfully created", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Study> editStudy(@PathVariable int id, @RequestBody Study study){
        Study stu = interStudy.findStudy(id);
        
        stu.setSchool(study.getSchool() == null ? stu.getSchool() : study.getSchool());
        stu.setName(study.getName() == null ? stu.getName() : study.getName());
        stu.setIsActual(study.getIsActual() == null ? stu.getIsActual() : study.getIsActual());
        stu.setYear_init(study.getYear_init() == 0 ? stu.getYear_init() : study.getYear_init());
        stu.setYear_end(study.getYear_end() == 0 ? stu.getYear_end() : study.getYear_end());
        stu.setPhoto_url(study.getPhoto_url() == null ? stu.getPhoto_url() : study.getPhoto_url());
        stu.setPerson(study.getPerson() == null ? stu.getPerson() : study.getPerson());
        
        interStudy.saveStudy(stu);
        
        return new ResponseEntity<>(stu, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudy(@PathVariable int id){
        interStudy.deleteStudy(id);
        
        return new ResponseEntity<>("Study Successfully deleted", HttpStatus.OK);
    }
}
