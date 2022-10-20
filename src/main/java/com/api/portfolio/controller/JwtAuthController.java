/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.controller;

import com.api.portfolio.config.JwtTokenUtil;
import com.api.portfolio.model.JwtRequest;
import com.api.portfolio.model.JwtResponse;
import com.api.portfolio.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lazar
 */
@RestController
@CrossOrigin(origins ="https://argprograma-front.web.app")
public class JwtAuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

            authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody JwtRequest user) throws Exception {
            return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String email, String password) throws Exception {
            try {
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            } catch (DisabledException e) {
                    throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                    throw new Exception("INVALID_CREDENTIALS", e);
            }
    }
    
}
