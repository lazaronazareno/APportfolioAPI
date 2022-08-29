/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.model.Person_User;
import java.util.List;

/**
 *
 * @author lazar
 */
public interface IPerson_UserService {
    
    public List<Person_User> getUsers();
    
    public void saveUser(Person_User user);
    
    public void deleteUser(int id);
    
    public Person_User findUser(int id);
}
