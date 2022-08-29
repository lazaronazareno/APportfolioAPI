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
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author lazar
 */
@Entity
@Table(name="proyect")
public class Proyect implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    
    private String name;
    private int year_made;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private String photo_url;
    @Column(nullable = true)
    private String repo_url;
    @Column(nullable = true)
    private String deploy_url;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable=false, referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Person person;

    public Proyect() {
    }

    public Proyect(int id, String name, int year_made, String description, String photo_url, String repo_url, String deploy_url) {
        this.id = id;
        this.name = name;
        this.year_made = year_made;
        this.description = description;
        this.photo_url = photo_url;
        this.repo_url = repo_url;
        this.deploy_url = deploy_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_made() {
        return year_made;
    }

    public void setYear_made(int year_made) {
        this.year_made = year_made;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getRepo_url() {
        return repo_url;
    }

    public void setRepo_url(String repo_url) {
        this.repo_url = repo_url;
    }

    public String getDeploy_url() {
        return deploy_url;
    }

    public void setDeploy_url(String deploy_url) {
        this.deploy_url = deploy_url;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
