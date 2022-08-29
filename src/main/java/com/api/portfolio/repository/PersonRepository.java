/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.portfolio.repository;

import com.api.portfolio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lazar
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}
