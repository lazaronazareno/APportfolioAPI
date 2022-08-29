/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.config;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author lazar
 */
public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(ApiError apiError) {
          return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
