/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.model.Person;

/**
 *
 * @author lazar
 */
public interface IPersonService {
    
    public Person getPerson();
    
    public void savePerson(Person person);
    
    public void deletePerson(int id);
    
    public Person findPerson(int id);
}
