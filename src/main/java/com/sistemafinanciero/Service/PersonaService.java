package com.sistemafinanciero.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemafinanciero.Entity.Persona;
import com.sistemafinanciero.Exception.*;
import com.sistemafinanciero.Repository.PersonaRepository;


@Service
public class PersonaService {
	
	@Autowired
	PersonaRepository  personaRepository;
	
	public Persona savePersona(Persona persona) {
		
		String documento = persona.getNumeroDocumento();
		
		Persona validarPersona = getPersonaByNumeroDocumento(documento);
		
		if(validarPersona == null) {
			if(persona.getTipoDocumento().isEmpty()) {
				throw new BadRequestException("El tipo de documento no puede estar vacio");
			}
			if(persona.getNumeroDocumento().isEmpty()) {
				throw new BadRequestException("El numero de documento no puede estar vacio");
			}
			if(persona.getPrimerNombre().isEmpty()) {
				throw new BadRequestException("El primer nombre de la persona no puede estar vacio");
			}
			if(persona.getPrimerApellido().isEmpty()) {
				throw new BadRequestException("El primer apellido de la persona no puede estar vacio");
			}
			if(persona.getFechaNacimiento() == null) {
				throw new BadRequestException("La fecha de nacimiento de la persona no puede estar vacia");
			}
			if(persona.getDireccion().isEmpty()) {
				throw new BadRequestException("La direccion de la persona no puede estar vacia");
			}
			if(persona.getTelefono().isEmpty()) {
				throw new BadRequestException("El telefono de la persona no puede estar vacio");
			}
			return personaRepository.save(persona);
		}else {
			throw new ConflictException("La persona que intenta crear ya existe ");
		}
		
	}
	
	public Persona getPersonaByNumeroDocumento(String numero_documento) {
		return personaRepository.getPersonaByNumeroDocumento(numero_documento);
	}
	
	public ArrayList<Persona> getPersonas(){
		return (ArrayList<Persona>) personaRepository.findAll();
	}
	
	public ArrayList<Persona> getPersonasActivas(){
		return (ArrayList<Persona>) personaRepository.getPersonasActivas();
	}
			
	public Optional<Persona> getPersonaById(int id){
		return personaRepository.findById(id);
	}
	
	public Persona updatePersona(Persona persona) {
		
		String documento = persona.getNumeroDocumento();
		Integer idPersona = persona.getIdPersona();
		
		Persona validarPersona = getPersonaParaActualizar(documento, idPersona);
		
		System.out.println("validar persona: " + validarPersona);
		
		if(validarPersona == null) {
			return personaRepository.save(persona);
		}else {
			throw new ConflictException("El numero de documento de la persona que intenta actualizar ya existe valide la Información");
		}
		
	}
	
	public Persona getPersonaParaActualizar (String numero_documento, Integer idPersona) {
		return personaRepository.getPersonaParaActualizar(numero_documento, idPersona);
	}
	
	public void updateEstadoPersona (Integer id, Boolean estado) {
		personaRepository.updateEstadoPersona(id, estado);
	}
}
