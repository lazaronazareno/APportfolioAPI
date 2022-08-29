/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.service;

import com.api.portfolio.model.JwtRequest;
import com.api.portfolio.model.Person;
import com.api.portfolio.model.Person_User;
import com.api.portfolio.repository.Person_UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author lazar
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {
    
    @Autowired private Person_UserRepository userRepo;
        
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
    }
    
        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            
                Person_User user = userRepo.findByEmail(email);
                if (user == null) {
                        throw new UsernameNotFoundException("User not found with email: " + email);
                }
                        return new User(user.getEmail(), user.getPassword(),
                                        new ArrayList<>());
        }
        
        public Person_User save(JwtRequest user) {
            Person_User newUser = new Person_User();
            newUser.setEmail(user.getEmail());
            newUser.setPassword(passwordEncoder().encode(user.getPassword()));
            return userRepo.save(newUser);
        }
        
         public Person_User save(Person_User user) {
            Person_User newUser = userRepo.findByEmail(user.getEmail());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(passwordEncoder().encode(user.getPassword()));
            return userRepo.save(newUser);
        }
}
