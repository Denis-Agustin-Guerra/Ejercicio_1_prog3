package com.utn.ejer01;

import com.utn.ejer01.entidades.Persona;
import com.utn.ejer01.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejer01Application {

	@Autowired
	private PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ejer01Application.class, args);
		System.out.println("La aplicación está funcionando en el puerto 8080 - Ejercicio 1 :)");
	}

	@Bean
	CommandLineRunner inicializar(PersonaRepository personaRepo) {
		return args -> {
			System.out.println("--------------- La aplicación está en funcionamiento ---------------");

			// Crear un objeto Persona de ejemplo
			Persona persona = new Persona();
			persona.setNombre("Juan");
			persona.setApellido("Pérez");
			persona.setEdad(30);

			// Guardar el objeto Persona en la base de datos
			personaRepo.save(persona);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada = personaRepo.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
			}
		};
	}
}
