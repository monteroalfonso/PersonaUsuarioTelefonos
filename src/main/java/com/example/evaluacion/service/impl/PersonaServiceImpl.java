package com.example.evaluacion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.evaluacion.constants.Constantes;
import com.example.evaluacion.entity.Persona;
import com.example.evaluacion.model.request.PersonaRequest;
import com.example.evaluacion.model.response.Respuesta;
import com.example.evaluacion.model.response.UsuarioResponse;
import com.example.evaluacion.reposiroty.PersonaRepository;
import com.example.evaluacion.service.PersonaService;
import com.example.evaluacion.service.TelefonoService;
import com.example.evaluacion.service.UsuarioService;
import com.example.evaluacion.utils.Utils;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired(required=true)
	PersonaRepository personaRepository;
	
	@Autowired(required = true)
	UsuarioService usuarioService;

	@Autowired(required = true)
	TelefonoService telefonoService;	
	
	public List<Persona> getAllPersona()   
	{  
		List<Persona> personas = new ArrayList<Persona>();  
		personaRepository.findAll().forEach(student -> personas.add(student));
		return personas;  
	}  	
	
	public ResponseEntity<Respuesta> createPersona(PersonaRequest personaRequest) throws Exception
	{  
		
		Persona persona = new Persona(personaRequest);
		Persona personaResponse = new Persona();
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		
		if (!Utils.validaPassword(persona.getPassword())){
			return new ResponseEntity<>(new Respuesta(Constantes.ERROR_FORMATO_CLAVE,usuarioResponse.toString()), HttpStatus.PRECONDITION_FAILED);
		}
		
		try {
			if (Utils.validaEmail(persona.getEmail())){
				Persona personaExistente = personaRepository.findByEmail(persona.getEmail());
				if (personaExistente != null) {
					return new ResponseEntity<>(new Respuesta(Constantes.PERSONA_EXISTENTE,usuarioResponse.toString()), HttpStatus.UNPROCESSABLE_ENTITY);
				}else {
					personaResponse.setTelefonos(persona.getTelefonos());
					persona.setTelefonos(null);
					persona = personaRepository.save(persona);
					usuarioResponse = new UsuarioResponse(usuarioService.createUsuario(persona));
					telefonoService.createTelefono(personaResponse.getTelefonos(), persona);
					return new ResponseEntity<>(new Respuesta(Constantes.PERSONA_CREADA,usuarioResponse.toString()), HttpStatus.OK);
				}
			}else {
				return new ResponseEntity<>(new Respuesta(Constantes.ERROR_FORMATO_CORREO,usuarioResponse.toString()), HttpStatus.PRECONDITION_FAILED);
			}		
		}catch (Exception e) {
			return new ResponseEntity<>(new Respuesta(Constantes.ERROR_NO_CONTROLADO,usuarioResponse.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
