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
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins ="https://argprograma-front.web.app")
@RequestMapping("/study")
public class StudyController {
    
    @Autowired IStudyService interStudy;
    @Autowired IPersonService interPerson;
    
    @GetMapping ()
    public ResponseEntity<List<Study>> getStudies(){
        List<Study> study = interStudy.getStudies();
        
        return ResponseEntity.status(HttpStatus.OK).body(study);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Study> getStudyById(@PathVariable int id){
        Study study = interStudy.findStudy(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(study);
    }
    
    @PostMapping()
    public ResponseEntity<Study> saveStudy(@RequestBody Study study){
        Person person = interPerson.getPerson();
        
        study.setPerson(person);
        interStudy.saveStudy(study);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(study);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Study> editStudy(@PathVariable int id, @RequestBody Study study){
        Study stu = interStudy.findStudy(id);
        
        stu.setSchool(study.getSchool() == null ? stu.getSchool() : study.getSchool());
        stu.setName(study.getName() == null ? stu.getName() : study.getName());
        stu.setDescription(study.getDescription() == null ? stu.getDescription() : study.getDescription());
        stu.setIsActual(study.getIsActual() == null ? stu.getIsActual() : study.getIsActual());
        stu.setDate_init(study.getDate_init() == null ? stu.getDate_init() : study.getDate_init());
        stu.setDate_end(study.getDate_end() == null ? stu.getDate_end() : study.getDate_end());
        stu.setPhoto_url(study.getPhoto_url() == null ? stu.getPhoto_url() : study.getPhoto_url());
        stu.setPerson(study.getPerson() == null ? stu.getPerson() : study.getPerson());
        
        interStudy.saveStudy(stu);
        
        return ResponseEntity.status(HttpStatus.OK).body(stu);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudy(@PathVariable int id){
        interStudy.deleteStudy(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(String.format("study %d successfully deleted", id));
    }
}
