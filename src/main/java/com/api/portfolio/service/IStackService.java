/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.model.Stack;
import java.util.List;

/**
 *
 * @author lazar
 */
public interface IStackService {
    
    public List<Stack> getStack();
    
    public void saveStack (Stack stack);
    
    public void deleteStack (int id);
    
    public Stack findStack (int id);
}
