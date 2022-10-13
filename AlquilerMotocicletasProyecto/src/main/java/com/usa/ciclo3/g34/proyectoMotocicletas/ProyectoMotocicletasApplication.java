package com.usa.ciclo3.g34.proyectoMotocicletas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//        (exclude={SecurityAutoConfiguration.class})
public class ProyectoMotocicletasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoMotocicletasApplication.class, args);
	}

}
