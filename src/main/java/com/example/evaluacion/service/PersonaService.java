package com.example.evaluacion.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.evaluacion.entity.Persona;
import com.example.evaluacion.model.request.PersonaRequest;
import com.example.evaluacion.model.response.Respuesta;

public interface PersonaService {

	public List<Persona> getAllPersona();
	public ResponseEntity<Respuesta> createPersona(PersonaRequest personaRequest) throws Exception;
	
}