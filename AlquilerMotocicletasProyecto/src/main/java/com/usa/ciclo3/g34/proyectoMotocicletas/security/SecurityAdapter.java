/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.g34.proyectoMotocicletas.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpine
 */

@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a
		.antMatchers("/", "/error", "/webjars/**","/api/**","/h2-console").permitAll().anyRequest().authenticated()
                
        ).exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login().defaultSuccessUrl("/paginas/inicio.html", true);

        http.cors().and().csrf().disable();

    }
    
}
