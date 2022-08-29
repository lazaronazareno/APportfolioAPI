/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.model;

import java.io.Serializable;

/**
 *
 * @author lazar
 */
public class JwtRequest implements Serializable {
    
    private static final long serialVersionUID = 5926468583005150707L;
	
    private String email;
    private String password;

    //need default constructor for JSON Parsing
    public JwtRequest() {
    }

    public JwtRequest(String email, String password) {
            this.setEmail(email);
            this.setPassword(password);
    }

    public String getEmail() {
            return this.email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getPassword() {
            return this.password;
    }

    public void setPassword(String password) {
            this.password = password;
    }
}
