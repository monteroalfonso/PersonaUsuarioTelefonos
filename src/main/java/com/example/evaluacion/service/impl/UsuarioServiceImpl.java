package com.example.evaluacion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.evaluacion.entity.Persona;
import com.example.evaluacion.entity.Usuario;
import com.example.evaluacion.model.request.PersonaRequest;
import com.example.evaluacion.model.response.Respuesta;
import com.example.evaluacion.model.response.UsuarioResponse;
import com.example.evaluacion.reposiroty.PersonaRepository;
import com.example.evaluacion.reposiroty.UsuarioRepository;
import com.example.evaluacion.service.UsuarioService;
import com.example.evaluacion.utils.Utils;
import com.example.evaluacion.constants.Constantes;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired(required=true)
	UsuarioRepository usuarioRepository;

	@Autowired(required=true)
	PersonaRepository personaRepository;
	
	public List<Usuario> getAllPersona()   
	{  
	List<Usuario> usuarios = new ArrayList<Usuario>();  
	usuarioRepository.findAll().forEach(usuario -> usuarios.add(usuario));
	return usuarios;  
	}  	
	
	public Usuario createUsuario(Persona persona){  
		
    	Usuario usuario = new Usuario();
    	usuario.setCreated(Utils.getSystenDate());
    	usuario.setModified(Utils.getSystenDate());	
    	usuario.setLastLogin(Utils.getSystenDate());
    	usuario.setToken(Utils.getToken());
    	usuario.setIsActive(Constantes.USUARIO_ACTIVO);
    	usuario.setPersona(persona);
		usuarioRepository.save(usuario);
		return usuario;
		
	}
	
	public Usuario editUsuario(Persona persona){  
		
    	Usuario usuario = this.getUsuario(persona);
    	usuario.setLastLogin(Utils.getSystenDate());
    	usuario.setModified(Utils.getSystenDate());
    	usuarioRepository.save(usuario);
		return usuario;

	}
	
	public Usuario getUsuario(Persona persona){
		return usuarioRepository.findByPersona(persona);
	}

	@Override
	public ResponseEntity<Respuesta> editUsuario(PersonaRequest personaRequest) throws Exception {
		
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		Persona persona = new Persona(personaRequest);
		
		Persona personaExistente = personaRepository.findByEmail(persona.getEmail());
		
		if (personaExistente != null) {
			usuarioResponse = new UsuarioResponse(this.editUsuario(personaExistente));		
			return new ResponseEntity<>(new Respuesta(Constantes.USUARIO_MODIFICADO,usuarioResponse.toString()), HttpStatus.OK);			
		}else {
			return new ResponseEntity<>(new Respuesta(Constantes.USUARIO_INEXISTENTE,usuarioResponse.toString()), HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}  	
	
}
