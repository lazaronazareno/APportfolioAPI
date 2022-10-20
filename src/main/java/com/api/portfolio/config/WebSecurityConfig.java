/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.portfolio.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author lazar
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    
    public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
            // configure AuthenticationManager so that it knows from where to load
            // user for matching credentials
            // Use BCryptPasswordEncoder
            auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
            // We don't need CSRF for this example
            httpSecurity.cors().and().csrf().disable()
                            // dont authenticate this particular request
                            .authorizeRequests().antMatchers("/authenticate", "/register").permitAll().
                    
                            // all other requests need to be authenticated
                    
                            anyRequest().authenticated().and().
                            // make sure we use stateless session; session won't be used to
                            // store user's state.
                            exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            
            // Add a filter to validate the tokens with every request
            httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            final CorsConfiguration config = new CorsConfiguration();

            config.setAllowedOrigins(Arrays.asList("https://argentina-programa-back-end.herokuapp.com"));
            config.setAllowedMethods(Arrays.asList("GET","POST","PATCH", "PUT", "DELETE", "OPTIONS", "HEAD"));
            config.setAllowCredentials(true);
            config.setAllowedHeaders(Arrays.asList("Authorization", "Requestor-Type", "Access-Control-Allow-Origin"));
            config.setExposedHeaders(Arrays.asList("X-Get-Header"));
            config.setMaxAge(3600L);
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", config);

            return source;
        }
}
