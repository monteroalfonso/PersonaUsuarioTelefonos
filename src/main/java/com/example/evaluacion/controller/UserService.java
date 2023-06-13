package com.example.evaluacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.evaluacion.model.request.PersonaRequest;
import com.example.evaluacion.model.response.Respuesta;
import com.example.evaluacion.service.PersonaService;
import com.example.evaluacion.service.TelefonoService;
import com.example.evaluacion.service.UsuarioService;

@RestController
public class UserService {
	
	@Autowired(required = true)
	PersonaService personaService;
	
	@Autowired(required = true)
	UsuarioService usuarioService;			

	@Autowired(required = true)
	TelefonoService telefonoService;
	
	@PostMapping(value = "/persona/crear", consumes = {"application/json"},produces = "application/json;charset=UTF-8")
    public ResponseEntity<Respuesta> createPersona(@RequestBody PersonaRequest personaRequest) throws Exception {

		return personaService.createPersona(personaRequest);

    }
	
	@PostMapping(value = "/persona/modificar", consumes = {"application/json"},produces = "application/json;charset=UTF-8")
    public ResponseEntity<Respuesta> modificarPersona(@RequestBody PersonaRequest personaRequest) throws Exception {

		return usuarioService.editUsuario(personaRequest);

    }	
    
}
