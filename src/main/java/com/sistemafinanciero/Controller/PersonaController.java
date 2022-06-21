package com.sistemafinanciero.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemafinanciero.Entity.Persona;
import com.sistemafinanciero.Service.PersonaService;

@RestController
@RequestMapping("personas")
@CrossOrigin(origins = "*")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@PostMapping("/guardarPersona")
	public Persona savePersona(@RequestBody Persona persona) {
		return personaService.savePersona(persona);
	}
	
	@GetMapping("/personas")
	public ArrayList<Persona> getPersonas(){
		//System.out.print("Entro a personas/get personas");
		return personaService.getPersonas();
	}
			
	@GetMapping("/personasActivas")
	public ArrayList<Persona> getPersonasActivas(){
		return personaService.getPersonasActivas();
	}
	
	@GetMapping("personaById/{id}")
	public Optional<Persona> getPersonaById(@PathVariable("id") Integer id){
		return this.personaService.getPersonaById(id);
	}
	
	@PutMapping("actualizarEstadoPersona/{id}/{estado}")
	public ResponseEntity<String> updateEstadoPersona( @PathVariable("id") Integer id, @PathVariable("estado") boolean estado){
		personaService.updateEstadoPersona(id, estado);
		return ResponseEntity.status(HttpStatus.OK).body("Persona Actualizada");
	}
	
	@PostMapping("actualizarPersona")
	public Persona updatePersona(@RequestBody Persona persona) {
		return this.personaService.updatePersona(persona);
	}

}
