package com.example.evaluacion.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.evaluacion.entity.Persona;
import com.example.evaluacion.entity.Usuario;
import com.example.evaluacion.model.request.PersonaRequest;
import com.example.evaluacion.model.response.Respuesta;

public interface UsuarioService {

	public List<Usuario> getAllPersona();
	public Usuario createUsuario(Persona persona);
	public Usuario editUsuario(Persona persona);
	public ResponseEntity<Respuesta> editUsuario(PersonaRequest personaRequest) throws Exception;
	
}