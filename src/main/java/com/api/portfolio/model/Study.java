/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author lazar
 */
@Entity
public class Study implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    
    private String school;
    private String name;
    private Boolean isActual;
    private int year_init;
    @Column(nullable = true)
    private int year_end;
    @Column(nullable = true)
    private String photo_url;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable=false, referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Person person;

    public Study() {
    }

    public Study(int id, String school, String name, Boolean isActual, int year_init, int year_end, String photo_url) {
        this.id = id;
        this.school = school;
        this.name = name;
        this.isActual = isActual;
        this.year_init = year_init;
        this.year_end = year_end;
        this.photo_url = photo_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActual() {
        return isActual;
    }

    public void setIsActual(Boolean isActual) {
        this.isActual = isActual;
    }

    public int getYear_init() {
        return year_init;
    }

    public void setYear_init(int year_init) {
        this.year_init = year_init;
    }

    public int getYear_end() {
        return year_end;
    }

    public void setYear_end(int year_end) {
        this.year_end = year_end;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
